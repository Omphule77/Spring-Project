package com.restcrud.example.restcrud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

	//create 'hello' endpoint 
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello World!";
	}
}
