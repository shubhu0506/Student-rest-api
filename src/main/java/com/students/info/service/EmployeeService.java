package com.students.info.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.students.info.entity.Employee;

@Component
public interface EmployeeService {

	 public List<Employee> getAllEmployees();
	 public Employee addEmployee(Employee employee);
	 public Employee editEmployees(Employee entity);
	 public void deleteEmployees(Integer id);
}
