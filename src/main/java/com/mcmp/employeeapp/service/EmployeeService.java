package com.mcmp.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcmp.employeeapp.model.Employee;
import com.mcmp.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployeeById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent())
			throw new RuntimeException();
		else {
			return employee;
		}
		
	}
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee updEmployee, Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent())
			throw new RuntimeException();
		else {
			
			return employeeRepository.save(updEmployee);
		}
		
	}
	
	public Employee createEmployee(Employee employee) {
		logger.info(employee.toString());
		return employeeRepository.save(employee);
		
	}
}
