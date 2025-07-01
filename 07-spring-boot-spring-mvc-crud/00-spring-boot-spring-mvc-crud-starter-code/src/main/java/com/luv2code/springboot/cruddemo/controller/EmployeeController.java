package com.luv2code.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService es;
	
	@Autowired
	public EmployeeController(EmployeeService emps) {
		es=emps;
	}
	
	@GetMapping("/list")
	public String showEmp(Model model) {
		List<Employee> listEmp = es.findAll();
		
		model.addAttribute("emp",listEmp);
		return "employee-home";
	}
	
	@GetMapping("/showFormForEmp")
	public String showForm(Model model) {
		model.addAttribute("addemp",new Employee());
		return "emp-add-form";
	}
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("Employee") Employee theEmp) {
		es.save(theEmp);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showForUpdate")
	public String showUpdate(@RequestParam("employeeId") int empid ,Model model) {
		Employee emp=es.findById(empid);
		System.out.println(emp);
		model.addAttribute("addemp", emp);
		return "emp-add-form";
	}
	
	@GetMapping("/delete")
	public String deleteEMp(@RequestParam("employeeId") int emp,Model model) {
		es.deleteById(emp);
		return "redirect:/employees/list";
	}
	
	
}
