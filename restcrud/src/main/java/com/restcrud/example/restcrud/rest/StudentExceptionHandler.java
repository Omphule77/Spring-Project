package com.restcrud.example.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
  
	//Add handling code
	//Custom Exception Handler 
		@ExceptionHandler
		public ResponseEntity<StudentError> handleException(StudentNotFoundException exc){
			StudentError error=new StudentError();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMassage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		//Handle All type of exception
		@ExceptionHandler
		public ResponseEntity<StudentError> handleAllException(Exception exc){
			StudentError error=new StudentError();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMassage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
}
