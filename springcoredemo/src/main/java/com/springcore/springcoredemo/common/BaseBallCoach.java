package com.springcore.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Lazy
public class BaseBallCoach implements Coach {
	
	public BaseBallCoach() {
		System.out.println("In Constructor: "+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkOut() {
		return "It is a baseball Coach";
	}

}
