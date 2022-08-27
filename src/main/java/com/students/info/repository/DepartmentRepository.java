package com.students.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.info.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

