package com.restcrudesecurityexample.restcrudesecurityexample.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class DemoSecurity {

	//Using Jdbc Authentication and Authorization
	
	@Bean
	public UserDetailsManager userDetail(DataSource ds) {
		return new JdbcUserDetailsManager(ds);
	}
	
	
	
	
	//This is InMemory Authentication and Authorization
	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//		UserDetails john = User.builder()
//				.username("john")
//				.password("{noop}test123")
//				.roles("Employee")
//				.build();
//		
//		UserDetails mary = User.builder()
//				.username("mary")
//				.password("{noop}test123")
//				.roles("Employee","Manager")
//				.build();
//		
//		UserDetails om = User.builder()
//				.username("om")
//				.password("{noop}test123")
//				.roles("Manager")
//				.build();
//		
//		return new InMemoryUserDetailsManager(john,mary,om);
//	}
//	
	@Bean
	public SecurityFilterChain filterRole(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers(HttpMethod.GET,"/api/hello").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET,"/api/hello/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST,"/api/hello").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT,"/api/hello").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE,"/api/hello").hasRole("ADMIN")
	  );
		
	http.httpBasic(Customizer.withDefaults());
	http.csrf(csrf-> csrf.disable());
	return http.build();
	}
}
