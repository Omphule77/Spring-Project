package com.jparepoproject.jparepoproject.dao;

import java.util.List;

import com.restcrud.project.restcrudeproject.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee emp);
	void delete(int id);
	
}
