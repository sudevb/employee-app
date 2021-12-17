package com.mcmp.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcmp.employeeapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
