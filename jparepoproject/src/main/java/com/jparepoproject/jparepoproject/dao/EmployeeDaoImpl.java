package com.jparepoproject.jparepoproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restcrud.project.restcrudeproject.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager em;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		em=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		//write query
		TypedQuery<Employee> theQuery=em.createQuery("select e from Employee e",Employee.class);
		//return the query
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Employee emp=em.find(Employee.class, id);
		return emp;
	}

	@Override
	public Employee save(Employee emp) {
		Employee employee=em.merge(emp);
		return employee;
	}

	@Override
	public void delete(int id) {
		//find employee using id
		Employee emp=em.find(Employee.class, id);
		//then remove
		em.remove(emp);
	}

}
