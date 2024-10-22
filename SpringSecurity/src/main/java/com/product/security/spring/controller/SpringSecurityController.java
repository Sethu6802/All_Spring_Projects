package com.product.security.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

	@GetMapping("/")
	public String greet() {
		return "Working";
	}
	
	@GetMapping("/admin")
	public String greetAdmin() {
		return " Admin @ Work";
	}
	
	@GetMapping("/user")
	public String greetUser() {
		return " User @ Work";
	}
	
}
