package com.fishfarming.service;

import com.fishfarming.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fishfarming.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	public boolean registerUser(Customer customerInfo) {
		return customerRepo.customerSignUp(customerInfo);
	}

	public boolean checkIfExistingUser(String userId) {
		return customerRepo.userIdExists(userId);
	}

	public int authenticateUser(Customer customerInfo) {
		return customerRepo.authenticate(customerInfo);
	}
}
