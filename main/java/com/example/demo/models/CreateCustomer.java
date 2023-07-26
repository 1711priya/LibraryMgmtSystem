package com.example.demo.models;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

;

public class CreateCustomer {

	@Size(min=3)
	private String name;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Size(min=8, max=15)
	@Pattern(regexp = "[a-zA-Z0-9@]+")
	private String password;
	
	private List<String> roles;

	public CreateCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateCustomer(@Size(min = 3) String name, @Email @NotNull String email,
			@NotNull @Size(min = 8, max = 15) @Pattern(regexp = "[a-zA-Z0-9@]+") String password, List<String> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
