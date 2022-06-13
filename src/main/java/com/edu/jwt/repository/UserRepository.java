package com.edu.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}
