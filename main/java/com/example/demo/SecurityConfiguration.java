package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user1 = User.withUsername("user")
				.password(encoder.encode("pass123"))
				.roles("USER")
				.build();
		
		UserDetails user2 = User.withUsername("admin")
				.password(encoder.encode("pass123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf( csrf -> csrf.disable())
		.authorizeHttpRequests( auth -> {
			try {
				auth.requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/users/**").hasRole("USER")
				.anyRequest().permitAll()
				.and().httpBasic();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return http.build();
	}

}
