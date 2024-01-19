package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
