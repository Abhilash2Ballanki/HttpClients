package com.motivity.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.motivity.dto.ManagerInput;
import com.motivity.model.Manager;

import reactor.core.publisher.Mono;

@Service
public class GraphQlService {
	
	private WebClient client = WebClient.create();
	private HttpGraphQlClient graphqlClient = HttpGraphQlClient
											.builder(client)
											.build();
	

public Mono<Manager> saveManager(ManagerInput manager) {
    String mutation = """
        mutation SaveManager($manager: ManagerInput!){
            saveManager(manager: $manager) {
                managerId
            }
        }
        """;

    Map<String, Object> variables = new HashMap<>();
    variables.put("manager", manager);

    return graphqlClient.mutate()
            .url("http://localhost:8082/graphql")
            .build()
            .document(mutation)
            .variables(variables) 
            .retrieve("saveManager")
            .toEntity(Manager.class)
            .map(t -> t).ignoreElement();
}
}
