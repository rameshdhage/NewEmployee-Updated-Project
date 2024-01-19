package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;

@RestController
@RequestMapping("/registerUser")
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		
		userRepo.save(user);
		
		return "User Registered successfuly";
		
		
	}

}
