package com.example.demo.services;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.CreateUser;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public User saveUser(CreateUser createUser) {
		
		if(this.userRepository.findByEmail(createUser.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use");
		}
		User user = new User();
		user.setName(createUser.getName());
		user.setEmail(createUser.getEmail());
		user.setRoles(Arrays.asList("ROLE_USER"));
		user.setPassword(encoder.encode(createUser.getPassword()));
		user.setCreatedAt(Instant.now());
		user.setModifiedAt(Instant.now());
		
		return this.userRepository.save(user);
		
	}
	
	public void deleteUser(Long id) {
		 this.userRepository.deleteById(id);
	}
	
	public User getUserById(Long id) {
		return this.userRepository.findById(id).get();
	}

}
