package com.motivity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String empCode;
	private String address;
	private String businessLine;

}
