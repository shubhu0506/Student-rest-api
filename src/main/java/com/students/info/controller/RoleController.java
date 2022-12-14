package com.students.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.Role;
import com.students.info.security.SecuredRestController;
import com.students.info.service.RoleImpl;

@RestController
public class RoleController  implements SecuredRestController{

	@Autowired
	private RoleImpl roleService;
	
	@PostMapping("/role")
	public Role createRole(@RequestBody Role role) {
	       return roleService.addRole(role);
	}


	@GetMapping("/role/{id}")
	public Role getRole(@PathVariable Long id) {
		 return roleService.getRole(id);
	}

	@GetMapping("/role")
	public List<Role> getRoles() {
		return roleService.getAllRole();
	}


}