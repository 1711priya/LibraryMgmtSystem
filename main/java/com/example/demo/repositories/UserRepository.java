package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.models.User;


public interface UserRepository extends CrudRepository<User, Long>{
	
	@RestResource(exported = false)
	public Optional<User> findByEmail(String email);

}
