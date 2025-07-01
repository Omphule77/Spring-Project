package com.restcrudesecurity.restcrudesecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurity {

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("Employee")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("Employee","Manager")
				.build();
		
		UserDetails om = User.builder()
				.username("om")
				.password("{noop}test123")
				.roles("Employee")
				.build();
		
		return new InMemoryUserDetailsManager(john,mary,om);
	}
}
