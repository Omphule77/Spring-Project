package com.springmvcvalidation.springmvcvalidation.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	//apply initBinder for removing white spaces
	@InitBinder
	public void initbind(WebDataBinder wb) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		wb.registerCustomEditor(String.class, ste);
	}

	@GetMapping("/om")
	public String show(Model model ) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/form")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult br) {
		System.out.println("Last Name |"+theCustomer.getLastName()+"|");
		System.out.println(br);
		if(br.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-info";
		}
		
	}
}
