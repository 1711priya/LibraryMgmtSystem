package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.CreateCustomer;
import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid CreateCustomer createCustomer){
		Customer customer = this.customerService.saveCustomer(createCustomer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

}
