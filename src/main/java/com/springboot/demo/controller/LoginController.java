package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;

@RestController
@RequestMapping("/loginuser")
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		
	User	storedUser=userRepo.findByUsername(user.getUsername());
		
	
	if(storedUser !=null && storedUser.getPassword().equals(user.getPassword())) {
		return "login successfull !";
		
		
	}else {
		return "Invalid credentials ! ";
	}
	}
	

}



