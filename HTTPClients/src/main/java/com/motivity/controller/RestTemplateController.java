package com.motivity.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.motivity.dto.ManagerResponse;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {
	
	private RestTemplate restTemplate;

	@Autowired
	public RestTemplateController(RestTemplateBuilder restTemplate) {
		this.restTemplate = restTemplate.build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<ManagerResponse> saveData(@RequestBody ManagerResponse managerResponse) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<ManagerResponse> entity = new HttpEntity<ManagerResponse>(managerResponse, headers);
		return restTemplate.exchange("http://localhost:8081/manager/save", HttpMethod.POST, entity, ManagerResponse.class);
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<ManagerResponse[]> saveAllData(@RequestBody List<ManagerResponse> list) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<List<ManagerResponse>> entity = new HttpEntity<>(list,headers);
		return restTemplate.exchange("http://localhost:8081/manager/saveAll", HttpMethod.POST, entity, ManagerResponse[].class);
	}
	
	@GetMapping("/getName/{id}")
	public ResponseEntity<String> getFullName(@PathVariable int id){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://localhost:8081/manager/getFullName/{id}", HttpMethod.GET, entity, String.class, id);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteData(@PathVariable int id){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://localhost:8081/manager/deleteByid/{id}", HttpMethod.DELETE, entity, String.class,id);
	}

}
