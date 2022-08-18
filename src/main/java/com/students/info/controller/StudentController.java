package com.students.info.controller;

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

import com.students.info.dto.Response;
import com.students.info.entity.Student;
import com.students.info.service.StudentService;

@RestController
public class StudentController {

	final static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
//get all students
	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public ResponseEntity<Response> getStudents() {
	     Response response=studentService.getAllStudent();
	     if(response.getStatusCode()==200)
	     {
	    	 return ResponseEntity.status(HttpStatus.OK).body(response);
	     }
	     else
	     {
	    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); 
	     }
	
	}

	// single student
	@GetMapping("/student/{rollNo}")
	public ResponseEntity<Response> getStudent(@PathVariable("rollNo") int rollno) {
		Response res= studentService.getStudentById(rollno);
		if(res.getStatusCode()==200)
		{
			 return ResponseEntity.status(HttpStatus.OK).body(res);
		}
		else
		{
	 	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}

	// add book
	@PostMapping("/student")
	public ResponseEntity<Response> addStudent(@RequestBody Student std) {
		Response response=this.studentService.addStudent(std);
		 if(response.getStatusCode()==200)
	     {
	    	 return ResponseEntity.status(HttpStatus.OK).body(response);
	     }
	     else
	     {
	    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); 
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
	public ResponseEntity<Response> updateStudent(@RequestBody Student std, @PathVariable("cityName") String cityName) {
		Response response=this.studentService.updateStudent(std, cityName);
		 if(response.getStatusCode()==200)
	     {
	    	 return ResponseEntity.status(HttpStatus.OK).body(response);
	     }
	     else
	     {
	    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); 
	     }


	}

}