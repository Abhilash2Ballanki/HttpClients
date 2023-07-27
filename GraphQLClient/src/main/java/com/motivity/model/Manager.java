package com.motivity.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Manager {
	
	private int managerId;
	private String managerFirstName;
	private String managerLastName;
	private String salary;
	private String managerCode;
	private String phone;
	private List<Employee> employees;

}
