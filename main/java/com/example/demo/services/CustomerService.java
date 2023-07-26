package com.example.demo.services;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.CreateCustomer;
import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Customer saveCustomer(CreateCustomer createCustomer) {
		
		if(this.customerRepository.findByEmail(createCustomer.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use");
		}
		Customer customer = new Customer();
		customer.setName(createCustomer.getName());
		customer.setEmail(createCustomer.getEmail());
		customer.setRoles(Arrays.asList("ROLE_USER"));
		customer.setPassword(encoder.encode(createCustomer.getPassword()));
		customer.setCreatedAt(Instant.now());
		customer.setModifiedAt(Instant.now());
		
		return this.customerRepository.save(customer);
		
	}

}
