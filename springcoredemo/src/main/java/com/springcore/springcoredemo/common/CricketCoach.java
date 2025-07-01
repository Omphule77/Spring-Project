package com.springcore.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In Constructor: "+ getClass().getSimpleName());
	}
	
	//Init Method for Bean
	@PostConstruct
	public void toInit()
	{
		System.out.println("In Init Menthod: "+getClass().getSimpleName());
	}
	//Destroy menthod for Bean
    
	@PreDestroy
	public void toDestroy()
	{
		System.out.println("In Destroy Menthod: "+getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkOut() {
		return "20 min Increase.";
	}
   
}
