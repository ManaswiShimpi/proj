package com.lti.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	public Employee findByName(String name);
	}
	

