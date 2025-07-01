package com.thymeleafdemo.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleafdemo.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	@Value("${operating}")
	private List<String> operating;
	
	@Value("${languages}")
	private List<String> languages;
	
	@Value("${contries}")
	private List<String> contries;

	@GetMapping("/showStudentForm")
	public String ShowForm(Model model) {
		model.addAttribute("student",new Student());
		System.out.println(contries);
		model.addAttribute("contries",contries);
		model.addAttribute("languages",languages);
		model.addAttribute("operating",operating);
		return "student-form";
	}
	
	@PostMapping("/processForm")
	public String process(@ModelAttribute("student") Student theStudent) {
		System.out.println("The Student is: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		System.out.println("Country: "+theStudent.getCountry());
		return "student-info";
	}
}
