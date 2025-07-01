package com.springcore.springcoredemo.common;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In SwimCoach Constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkOut() {
		
		return "In Swim class";
	}

}
