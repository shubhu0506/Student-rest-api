package com.students.info.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.Student;
import com.students.info.services.StudentService;

@RestController
public class StudentController {

	final static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
//get all students
	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> list = studentService.getAllStudent();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// single student
	@GetMapping("/student/{rollNo}")
	public ResponseEntity<Student> getStudent(@PathVariable("rollNo") int rollno) {
		Student std = studentService.getStudentById(rollno);
		return ResponseEntity.of(Optional.of(std));
	}

	// add book
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student std) {
		Student b = null;
		try {
			b = this.studentService.addStudent(std);
			logger.info("{} Students: " +std);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// delete student
	@DeleteMapping("/student/{rollNo}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("rollNo") int rollNo) {
		try {
			this.studentService.deleteStudent(rollNo);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// update handler
	@PutMapping("/student/{cityName}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student std, @PathVariable("cityName") String cityName) {
		try {
			this.studentService.updateStudent(std, cityName);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}