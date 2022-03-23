package com.fishfarming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fishfarming.model.Customer;
import com.fishfarming.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService myCustomerService;
	
	@PostMapping("/signUp")
	public String userSignup(@RequestBody Customer customerInfo) {
		myCustomerService.registerUser(customerInfo);
		return "success";
	}
}
