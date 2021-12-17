package com.mcmp.employeeapp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcmp.employeeapp.model.Employee;
import com.mcmp.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok().body(employeeService.getEmployees());
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		return ResponseEntity.ok().body(employeeService.updateEmployee(employee, id));
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEmployee.getId())
                .toUri();
		return ResponseEntity.created(uri).body(createdEmployee);
	}
}
