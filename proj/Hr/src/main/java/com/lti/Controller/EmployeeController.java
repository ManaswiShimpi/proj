package com.lti.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;

@RestController
@RequestMapping("/hr")
public class EmployeeController {
	
		@Autowired
	private EmployeeService employeeService;

		@RequestMapping("/create")
		public String create(@RequestParam("name") String name, @RequestParam ("department") String department, @RequestParam (value = "salary", required = true) float salary)
		{
			Employee p=employeeService.create(name,department,salary);
		return p.toString();
	}
		@RequestMapping("/get")
		public Employee getEmployee(@RequestParam ("name") String name)
		{
			return employeeService.getByName(name); 
		}
		@RequestMapping("/getAll")
	public List<Employee> getAll()
	{
		return employeeService.getAll();
	}
		
		@RequestMapping("/update")
	public String update(@RequestParam String name,@RequestParam String department, @RequestParam float salary)
	{
			Employee p=employeeService.update(name, department,salary);
		return p.toString();
	}
		@RequestMapping("/delete")
	public String delete(@RequestParam String name)
	{
			employeeService.delete(name);
		return"Deleted"+ name;
	}
		@RequestMapping("/deleteAll")
	public String deleteAll()
	{
			employeeService.deleteAll();
		return"Deleted all records";
	}

	}

