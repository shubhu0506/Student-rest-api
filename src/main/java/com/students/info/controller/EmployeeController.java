package com.students.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.Employee;
import com.students.info.security.SecuredRestController;
import com.students.info.service.EmployeeServiceImpl;

@RestController
public class EmployeeController implements SecuredRestController  {
	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("/get-employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.addEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.editEmployees(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@RequestParam(name = "employeeId") Integer employeeId) {
		employeeService.deleteEmployees(employeeId);
		return new ResponseEntity<>("Employee with ID :" + employeeId + " deleted successfully", HttpStatus.OK);
	}
}