package com.students.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.students.info.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	
}
