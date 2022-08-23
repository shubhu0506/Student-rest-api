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
import com.students.info.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepository;

	@RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/user/details/{id}")
	public User getUser(@PathVariable Long id) {
		if (userRepository.findById(id).isPresent())
			return userRepository.findById(id).get();
		else
			return null;
	}

	@GetMapping("/user/all")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}