package com.ust.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/service")
public class HelloController {
	
	@Autowired
	Environment env;
	
	
	@GetMapping("/test")
	public String confirm() {
		return "connected.....port #" + env.getProperty("local.server.port");
	}

}
