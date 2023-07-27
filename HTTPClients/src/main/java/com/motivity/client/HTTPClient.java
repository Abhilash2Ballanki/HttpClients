package com.motivity.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.motivity.dto.ManagerResponse;

@FeignClient(name = "Manager-Service",url = "http://localhost:8081/manager")
public interface HTTPClient {
	
	@PostMapping("/save")
	public ManagerResponse addManager(@RequestBody ManagerResponse response);
	
	@PostMapping("/saveAll")
	public List<ManagerResponse> addAllManagers(@RequestBody List<ManagerResponse> managers);
	
	@GetMapping("/getFullName/{id}")
	public String getFullName(@PathVariable("id") int id);
	
	@GetMapping("/empCode")
	public List<ManagerResponse> getByEmpCode(@RequestParam String empCode);
	
	@GetMapping("/empEndCode")
	public List<ManagerResponse> getByEmpCodeEnding(@RequestParam String empCode);

}
