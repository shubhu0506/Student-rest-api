package com.students.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.students.info.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
