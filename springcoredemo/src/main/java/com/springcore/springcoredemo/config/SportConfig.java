package com.springcore.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcore.springcoredemo.common.Coach;
import com.springcore.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean("Om")
	public Coach swimCoach()
	{
		return new SwimCoach();
	}

}
