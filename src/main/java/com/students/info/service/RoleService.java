package com.students.info.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.students.info.entity.Role;

@Component
public interface RoleService {
	public List<Role> getAllRole();
	public Role getRole(long id);
	public Role addRole(Role role);
}
