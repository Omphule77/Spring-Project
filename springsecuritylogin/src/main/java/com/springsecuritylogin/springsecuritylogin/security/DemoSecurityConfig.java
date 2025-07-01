package com.springsecuritylogin.springsecuritylogin.security;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetail() {
		UserDetails john=User.builder()
				         .username("john")
				         .password("{noop}test123")
				         .roles("EMPLOYEE")
				         .build();
		
		UserDetails mary=User.builder()
		         .username("mary")
		         .password("{noop}test123")
		         .roles("EMPLOYEE","MANAGER")
		         .build();
		
		UserDetails om=User.builder()
		         .username("om")
		         .password("{noop}test123")
		         .roles("EMPLOYEE","MANAGER","ADMIN")
		         .build();
		
		return new InMemoryUserDetailsManager(john,mary,om);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		      configurer
		      .requestMatchers("/").hasRole("EMPLOYEE")
		      .requestMatchers("/leaders/**").hasAnyRole("MANAGER")
		      .requestMatchers("/systems/**").hasAnyRole("ADMIN")
		      .anyRequest().authenticated()
				)
		.formLogin(form->
		  form.loginPage("/showCustomForm")
		      .loginProcessingUrl("/submitHere")
		      .permitAll()
				)
		.logout(logout->logout.permitAll())
		.exceptionHandling(configurer->
				configurer
				          .accessDeniedPage("/access-denied")
				);
		return http.build();
	}
}
