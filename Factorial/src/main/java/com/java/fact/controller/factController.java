package com.java.fact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fact")
public class factController {
	
	@GetMapping("/number/{i}")
	public int factorial(@PathVariable int i) {
				
		if(i == 1) {
			return 1;
		}
		
		return i * factorial(i-1);
	}
	
}
