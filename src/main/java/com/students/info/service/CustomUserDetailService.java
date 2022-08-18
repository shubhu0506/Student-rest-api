package com.students.info.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailService implements UserDetailsService{

	@Value("${info.app.username}")
	private String username;
	
	@Value("${info.app.password}")
	private String password;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		if(userName.equals(username))
		{
			return new User(username,password,new ArrayList<>());
		}else
		{
			throw new UsernameNotFoundException("User Not Found!");
		}
	}

}