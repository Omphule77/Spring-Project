package com.restcrud.example.restcrud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcrud.example.restcrud.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
	private List<Student> ls;
	//define the @Postconstruct for student data... load only once after constructor
	
	@PostConstruct
	public void loadData()
	{
		ls=new ArrayList<>();
		
		ls.add(new Student("Om","Phule"));
		ls.add(new Student("Pranav","Adsule"));
		ls.add(new Student("Prafful","Babar"));
		ls.add(new Student("Neha","Rokade"));
	}

	//Add the EndPoint
	
	@GetMapping("/students")
	public List<Student> listStudents(){
		return ls;
	}
	
	//Path Variable 
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//check by its size and throw exception
		if((studentId>=ls.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student Id Not Found: "+studentId);
		}
		return ls.get(studentId);
	}
	
}
