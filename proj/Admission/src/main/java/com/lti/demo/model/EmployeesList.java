package com.lti.demo.model;

import java.util.List;

public class EmployeesList {
	public static List<Employee> employees;

	public static List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
