package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.models.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	@RestResource(exported = false)
	public Optional<Customer> findByEmail(String email);

}
