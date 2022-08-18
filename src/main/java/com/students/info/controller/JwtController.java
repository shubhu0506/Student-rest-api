package com.students.info.controller;

import org.slf4j.Logger;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.helper.JwtUtil;
import com.students.info.model.JwtRequest;
import com.students.info.model.JwtResponse;
import com.students.info.service.CustomUserDetailService;


@RestController
public class JwtController {
    
	private static Logger log = LoggerFactory.getLogger(JwtController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
	    log.debug("JwtRequest : "+ jwtRequest);
		try 
		{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}catch(UsernameNotFoundException e) 
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails=this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
         String token=this.jwtUtil.generateToken(userDetails);
         
         log.info("this is token" + token);
         //System.out.println(token);
         return ResponseEntity.ok(new JwtResponse(token));
	}
 }