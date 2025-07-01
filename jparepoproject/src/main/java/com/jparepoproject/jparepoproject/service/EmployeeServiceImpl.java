package com.jparepoproject.jparepoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restcrud.project.restcrudeproject.dao.EmployeeDao;
import com.restcrud.project.restcrudeproject.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao em;
	//inject EmployeeDao
	public EmployeeServiceImpl(EmployeeDao empdao) {
		em=empdao;
	}
	
	//methods overrids
	@Override
	public List<Employee> findAll() {
		return em.findAll();
	}

	@Override
	public Employee findById(int id) {
		return em.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		return em.save(emp);
	}

	@Override
	@Transactional
	public void delete(int id) {
		em.delete(id);
	}

}
