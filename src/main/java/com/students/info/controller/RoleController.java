package com.students.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.Role;
import com.students.info.repo.RoleRepo;

@RestController
public class RoleController {
	@Autowired
	private RoleRepo roleRepository;

	@PostMapping("/role/create")
	public Role createRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}


	@GetMapping("/role/details/{id}")
	public Role getRole(@PathVariable Long id) {
		if (roleRepository.findById(id).isPresent())
			return roleRepository.findById(id).get();
		else
			return null;
	}

	@GetMapping("/role/all")
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}


}