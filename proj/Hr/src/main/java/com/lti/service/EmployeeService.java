package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Employee;
import com.lti.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
private EmployeeRepository employeeRepository;

//create
public Employee create(String name,String department,float salary)
{
	return employeeRepository.save(new Employee(name,department,salary)) ;

}
//retrive
public List<Employee> getAll()
{
	return employeeRepository.findAll();
}
public Employee getByName(String name) 
{
	return employeeRepository.findByName(name);
}
//update
public Employee update(String name,String department,float salary)
{
	Employee p=employeeRepository.findByName(name);
	p.setDepartment(department);
	p.setSalary(salary);
	return employeeRepository.save(p);
}
//Delete
public void deleteAll()
{
	employeeRepository.deleteAll();
}
public void delete(String name)
{
	Employee p=employeeRepository.findByName(name);
	employeeRepository.delete(p);
}
}
