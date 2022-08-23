package com.students.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.students.info.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> { 
}