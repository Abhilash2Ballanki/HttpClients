package com.motivity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String dept;
	private int salary;
	private String empCode;
	
}
