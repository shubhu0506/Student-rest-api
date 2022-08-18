package com.students.info.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.students.info.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response extends BaseResponse{

	private List<String> data;
	private String token;
	private int dataSize;
	private List<Student> studentList;
	private Student student;

	public Response(String token) {
		this.token = token;
	}

	public Response(int statusCode, String message) {
		super(statusCode, message);
	}

	public Response(int statusCode, String message, String token) {
		super(statusCode, message);
		this.token = token;
	}
	
	public Response(int statusCode, String message, int dataSize) {
		super(statusCode, message);
		this.dataSize = dataSize;
	}
	
	
	

}