package com.students.info.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.students.info.entity.Student;
public interface StudentsRepository extends JpaRepository<Student,Integer>{

	public Student findById(int id);
}
