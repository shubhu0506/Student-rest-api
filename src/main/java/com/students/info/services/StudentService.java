package com.students.info.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.student.info.customexception.CustomExceptionHandler;
import com.students.info.config.AspectConfig;
import com.students.info.entity.Student;
import com.students.info.repo.StudentsRepo;

@Component
public class StudentService {
	
	final static Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentsRepo studentRepository;

	// get all students
	public List<Student> getAllStudent() {
		List<Student> list = (List<Student>) this.studentRepository.findAll();
		try {
			if (list.size() == 0) {
				throw new CustomExceptionHandler("No Details to display");
			}
		} catch (CustomExceptionHandler e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	// get single studnet by id
	public Student getStudentById(int rollno) {
		Student std = null;
		try {

			std = this.studentRepository.findById(rollno);
			if(std==null)
			{
				throw new CustomExceptionHandler("no such student found");
			}
		} catch (CustomExceptionHandler e) {
			logger.error(e.getMessage());
		}
		return std;
	}

	// adding student
	public Student addStudent(Student b) {
		Student result = studentRepository.save(b);
		return result;
	}

	// delete student
	public void deleteStudent(int rollno) {

		studentRepository.deleteById(rollno);
	}

	// update the student
	public void updateStudent(Student student, String cname) {

		student.setCity(cname);
		studentRepository.save(student);
	}

}
