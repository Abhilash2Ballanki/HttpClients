package com.motivity.dto;

import java.util.List;

import com.motivity.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerInput {
	
	private String managerFirstName;
	private String managerLastName;
	private String salary;
	private String managerCode;
	private String phone;
	private List<Employee> employees;

}
