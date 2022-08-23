package com.students.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.info.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}

