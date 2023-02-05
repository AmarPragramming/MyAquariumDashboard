package com.fishfarming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fishfarming.model.Customer;
import com.fishfarming.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService myCustomerService;

    @PostMapping("/signUp")
    public boolean userSignup(@RequestBody Customer customerInfo) {
        return myCustomerService.registerUser(customerInfo);

    }

    @GetMapping("/isUserIdAlreadyTaken")
    public boolean userSignup(@RequestParam String userId) {
            return myCustomerService.checkIfExistingUser(userId);
    }

    @PostMapping("/authenticate")
    public  int ValidateUserCredentials(@RequestBody Customer customerInfo) {
        return myCustomerService.authenticateUser(customerInfo);
    }

}
