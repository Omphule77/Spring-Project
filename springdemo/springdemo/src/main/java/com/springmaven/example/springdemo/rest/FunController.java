package com.springmaven.example.springdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/team")
	public String teamInfo()
	{
		return "Coach Name: "+coachName+" Team Name: "+teamName;
	}
   
	@GetMapping("/")
	public String sayHellow()
	{
		return "Hello World!";
	}
	@GetMapping("/work")
	public String work()
	{
		return "Hello World I Am At Cognizant";
	}
}
