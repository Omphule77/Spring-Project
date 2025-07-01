package com.springsecuritylogin.springsecuritylogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showCustomForm")
	public String CustomForm() {
//		return "custom-form";
		return "fancy-login";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		return "leader-page";
	}
	
	@GetMapping("/systems")
	public String system() {
		return "system-page";
	}
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}
}
