package com.motivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motivity.dto.ManagerInput;
import com.motivity.service.GraphQlService;

@RestController
public class GraphQLController {
	
	@Autowired
	private GraphQlService qlService;
	
	@PostMapping("/save")
	public String saveManager(@RequestBody ManagerInput manager){
		 qlService.saveManager(manager);
		return "Data is successfully stored";
	}

}
