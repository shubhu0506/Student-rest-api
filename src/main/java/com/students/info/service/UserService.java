package com.students.info.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.students.info.entity.User;

@Component
public interface UserService {
   
	public User addUser(User user);
	public List<User> getAllUser();
	public User getById(long id);
}
