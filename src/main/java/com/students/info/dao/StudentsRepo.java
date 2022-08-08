package com.students.info.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.students.info.entity.Student;
public interface StudentsRepo extends CrudRepository<Student,Integer>{

	public Student findById(int id);
}
