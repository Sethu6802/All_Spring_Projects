package com.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.MyUser;
import com.db.repo.UserRepo;

@RestController
@RequestMapping("/registry")
public class RegistrationController {

	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/add")
	public MyUser newUser(@RequestBody MyUser user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
}
