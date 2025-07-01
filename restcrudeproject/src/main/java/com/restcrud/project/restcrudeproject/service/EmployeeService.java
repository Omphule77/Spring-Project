package com.restcrud.project.restcrudeproject.service;

import java.util.List;

import com.restcrud.project.restcrudeproject.entity.Employee;

public interface EmployeeService {
   
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee emp);
	void delete(int id);
}
