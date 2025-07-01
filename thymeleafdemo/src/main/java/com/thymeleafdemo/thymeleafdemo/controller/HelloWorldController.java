package com.thymeleafdemo.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	//for showing the form
	@RequestMapping("/showform")
	public String showForm() {
		return "helloform";
	}
	
	@RequestMapping("/processform")
	public String process() {
		return "hellostudent";
	}
	
	@RequestMapping("/processformUpper")
	public String processToUpper(HttpServletRequest request,Model model) {
		//take the data from the form
		String data=request.getParameter("studentName");
		//perform upperCase
		data=data.toUpperCase();
		//create message
		String result="Yo! "+data;
		//add to model
		model.addAttribute("msg",result);
		return "hellostudent";
	}
	
	@PostMapping("/processformUpperVersionTwo")
	public String processToUpperVersionTwo(@RequestParam("studentName") String name,Model model) {
		//perform upperCase
		name=name.toUpperCase();
		//create message
		String result="Yo! is your Name umhh "+name;
		//add to model
		model.addAttribute("msg",result);
		return "hellostudent";
	}
}
