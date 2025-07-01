package com.restcrud.project.restcrudeproject.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restcrud.project.restcrudeproject.dao.EmployeeDao;
import com.restcrud.project.restcrudeproject.dao.EmployeeRepository;
import com.restcrud.project.restcrudeproject.entity.Employee;
import com.restcrud.project.restcrudeproject.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private ObjectMapper objectMapper;
	//make connection to Service Layer
	private EmployeeService es;
	
	//convinient option of jpaRepository
	private EmployeeRepository er;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService,ObjectMapper ob,EmployeeRepository empr) {
		this.es=employeeService;
		objectMapper=ob;
		er=empr;
	}
	//getting all list of Employees for only JPA
//	@GetMapping("/employees")
//	public List<Employee> findAllEmployee(){
//		return es.findAll();
//	}
	
	
	//For Spring Data JPA extends JpaRepository
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		return er.findAll();
	}
	
	//getting only one Employee using id
	@GetMapping("/employees/{empId}")
	public Employee findEmpById(@PathVariable int empId) {
		Employee emp=es.findById(empId);
		if(emp==null) {
			throw new RuntimeException("Employee not found: "+empId);
		}
		return emp;
	}
	
	//save the new Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		emp.setId(0);
		return es.save(emp);
	}
	
	//update the Employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		Employee em=es.save(emp);
		return em;
	}
	
	//Apply Patch
	@PatchMapping("/employees/{employeeId}")
	public Employee patchMap(@PathVariable int employeeId,@RequestBody Map<String,Object> patchLoad) {
		Employee theEmployee=es.findById(employeeId);
		
		//if null throw exception
		if(theEmployee==null) {
			throw new RuntimeException("The Id Not Found");
		}
		//if request body update the id
		if(patchLoad.containsKey("id")) {
			throw new RuntimeException("Id not be updated");
		}
		Employee emp=apply(patchLoad,theEmployee);
		
		Employee em=es.save(emp);
		return em;
	}
	
	
	private Employee apply(Map<String, Object> patchLoad, Employee theEmployee) {
		//convert employee into JSON object node
		ObjectNode emp=objectMapper.convertValue(theEmployee, ObjectNode.class);
		
		//Convert Patch into JSON object node
		ObjectNode patch=objectMapper.convertValue(patchLoad, ObjectNode.class);
		
		//merge it
		emp.setAll(patch);
		//covert json object to employee object
		return objectMapper.convertValue(emp, Employee.class);
	}
	
	//delete an employee using id
	@DeleteMapping("/employee/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee em=es.findById(employeeId);
		
		//thow exception if it null
		if(em==null) {
			throw new RuntimeException("Employee is null");
		}
		
		es.delete(employeeId);
		return "EMployee deleted"+employeeId;
	}
}
