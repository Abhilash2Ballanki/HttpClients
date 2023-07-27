package com.motivity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motivity.client.HTTPClient;
import com.motivity.dto.ManagerResponse;

@RestController
@RequestMapping("/feign")
public class ClientController {
	
	@Autowired
	private HTTPClient feignClient;
	
	@PostMapping("/save")
	public ResponseEntity<ManagerResponse> saveManagerByClient(@RequestBody ManagerResponse managerDetails){
		return new ResponseEntity<ManagerResponse>(feignClient.addManager(managerDetails), HttpStatus.OK);
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<List<ManagerResponse>> saveAllManager(@RequestBody List<ManagerResponse> list){
		return new ResponseEntity<List<ManagerResponse>>(feignClient.addAllManagers(list), HttpStatus.OK);
	}
	
	@GetMapping("/fullName/{id}")
	public ResponseEntity<String> getFullName(@PathVariable int id){
		return new ResponseEntity<String>(feignClient.getFullName(id), HttpStatus.OK);
	}
	
	@GetMapping("/empcode")
	public ResponseEntity<List<ManagerResponse>> getByCode(@RequestParam String empCode){
		return new ResponseEntity<List<ManagerResponse>>(feignClient.getByEmpCode(empCode), HttpStatus.OK);
	}
	
	@GetMapping("/empEndCode")
	public ResponseEntity<List<ManagerResponse>> getByEmpCodeEnding(@RequestParam("empCode") String empCode){
		return new ResponseEntity<List<ManagerResponse>>(feignClient.getByEmpCodeEnding(empCode),HttpStatus.OK);
	}

}
