package com.fishfarming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return "Hi there! "+name;
	}
}
