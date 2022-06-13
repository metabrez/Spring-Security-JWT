package com.edu.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.jwt.entity.AuthRequest;
import com.edu.jwt.util.JwtUtil;

@RestController
public class WelcomeController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String hello() {

		return "Welcome to Spring security";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword());
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
