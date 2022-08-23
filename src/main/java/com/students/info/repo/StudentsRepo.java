package com.students.info.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.students.info.entity.Student;
public interface StudentsRepo extends JpaRepository<Student,Integer>{

	public Student findById(int id);
}
