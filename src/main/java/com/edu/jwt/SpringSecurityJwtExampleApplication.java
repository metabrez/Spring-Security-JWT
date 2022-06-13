package com.edu.jwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.jwt.entity.User;
import com.edu.jwt.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
	
	@Autowired
	private UserRepository repository;
	
	
	@PostConstruct
	public void initUsers() {
		
		List<User> users = Stream.of(
				
				new User(101, "java","password", "java@gmail.com"),
				new User(102, "user1","pwd1", "pwd1@gmail.com"),
				new User(103, "user2","pwd2", "pwd2@gmail.com"),
				new User(104, "user3","pwd3", "pwd3@gmail.com")
				).collect(Collectors.toList());
		
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
