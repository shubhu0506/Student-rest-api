package com.students.info.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.student.info.customexception.CustomExceptionHandler;
import com.students.info.config.AspectConfig;
import com.students.info.dto.Response;
import com.students.info.entity.Student;
import com.students.info.repository.StudentsRepository;

@Component
public class StudentService {
	
	final static Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentsRepository studentRepository;

	// get all students
	public Response getAllStudent() {
		Response getListOfStudent = new Response();
		List<Student> list = (List<Student>) this.studentRepository.findAll();
		try {
			if (list.size() == 0) {
				throw new CustomExceptionHandler("No Details to display");
			}
			getListOfStudent.setStatusCode(HttpStatus.OK.value());
			getListOfStudent.setStudentList(list);
		} catch (CustomExceptionHandler e) {
			getListOfStudent.setStatusCode(HttpStatus.BAD_REQUEST.value());
			getListOfStudent.setMessage("No Data");
			logger.error(e.getMessage());
		}
		return getListOfStudent;
	}

	// get single studnet by id
	public Response getStudentById(int rollno) {
		Response getStudent = new Response();
		Student std = null;
		try {
			std = this.studentRepository.findById(rollno);
			if(std==null)
			{
				throw new CustomExceptionHandler("no such student found");
			}
			getStudent.setStatusCode(HttpStatus.OK.value());
			getStudent.setStudent(std);
		} catch (CustomExceptionHandler e) {
			getStudent.setStatusCode(HttpStatus.BAD_REQUEST.value());
			getStudent.setMessage("No Data");
			logger.error(e.getMessage());
		}
		return getStudent;
	}

	// adding student
	public Response addStudent(Student b) {
		Response addStudent = new Response();
		Student result = studentRepository.save(b);
		addStudent.setStatusCode(HttpStatus.OK.value());
		addStudent.setStudent(result);
		return addStudent;
	}

	// delete student
	public void deleteStudent(int rollno) {

		studentRepository.deleteById(rollno);
	}

	// update the student
	public Response updateStudent(Student student, String cname) {
		Response updateStudent = new Response();
		student.setCity(cname);
		Student result=studentRepository.save(student);
		updateStudent.setStatusCode(HttpStatus.OK.value());
		updateStudent.setStudent(result);
		return updateStudent;
	}

}
