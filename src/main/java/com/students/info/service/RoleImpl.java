package com.students.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.info.entity.Role;
import com.students.info.repository.RoleRepository;

@Service
public class RoleImpl  implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRole(long id) {
		if (roleRepository.findById(id).isPresent())
			return roleRepository.findById(id).get();
		else
			return null;
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

}
