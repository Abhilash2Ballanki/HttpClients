package com.motivity.controller;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.motivity.dto.ManagerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/webclient")
public class WebClientController {
	
	private WebClient client;
	
	@PostConstruct
	public void init() {
		client = WebClient
				.builder()
				.baseUrl("http://localhost:8081/manager")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	@GetMapping("/empcodeContain")
	public Flux<ManagerResponse> getByEmpCodeContain(@RequestParam String empCode){
		return client
				.get()
				.uri("/empCodeContain?empCode="+empCode)
				.retrieve()
				.bodyToFlux(ManagerResponse.class);
	}
	
	@GetMapping("/empCodeNot")
	public Flux<ManagerResponse> getbyEmpCodeNotHave(@RequestParam String empCode){
		return client
				.get()
				.uri("/empCodeNotEqual?empCode="+empCode)
				.retrieve()
				.bodyToFlux(ManagerResponse.class);
				
	}
	
	@PutMapping("/updating/{id}")
	public Mono<ManagerResponse> updateData(@PathVariable int id, @RequestBody ManagerResponse managerResponse){
		return client
				.put()
				.uri("/update/"+id)
				.syncBody(managerResponse)
				.retrieve()
				.bodyToMono(ManagerResponse.class);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<String> deleteData(@PathVariable int id){
		return client
				.delete()
				.uri("/deleteByid/"+id)
				.retrieve()
				.bodyToMono(String.class);
	}
	
	@GetMapping("/getData")
	public Flux<ManagerResponse> getAllData(){
		return client
				.get()
				.uri("/getAll")
				.retrieve()
				.bodyToFlux(ManagerResponse.class);
	}
}
