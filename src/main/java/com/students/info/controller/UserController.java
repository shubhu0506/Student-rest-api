package com.students.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.User;
import com.students.info.security.SecuredRestController;
import com.students.info.service.UserServiceImpl;

@RestController
public class UserController implements SecuredRestController {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getById(id);
	}

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.getAllUser();
	}

}