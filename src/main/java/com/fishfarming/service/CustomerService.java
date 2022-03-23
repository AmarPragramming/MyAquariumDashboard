package com.fishfarming.service;

import org.springframework.stereotype.Service;

import com.fishfarming.model.Customer;

@Service
public class CustomerService {

	public String registerUser(Customer customerInfo) {
		System.out.println(customerInfo.getName());
		System.out.println(customerInfo.getAddress().getCity());
		return "success";
	}
	
}
