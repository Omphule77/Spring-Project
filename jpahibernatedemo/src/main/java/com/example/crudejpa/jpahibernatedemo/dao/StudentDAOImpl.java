package com.example.crudejpa.jpahibernatedemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudejpa.jpahibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);;
		
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//write Query
		TypedQuery theQuery=entityManager.createQuery("select s From Student s where last_name='Phule'",Student.class);
		
		//Return Query
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String LName) {
		//write query
		TypedQuery<Student> theQuery=entityManager.createQuery("select s from Student s where last_name=:theData",Student.class);
		//set parameter
		theQuery.setParameter("theData", LName);
		//return query
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		//retrive that id
		   Student myStudent=entityManager.find(Student.class, id);
		//delete
		   entityManager.remove(myStudent);
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		//write custume Query
		int numberOfRows=entityManager.createQuery("Delete from Student").executeUpdate();
		return numberOfRows;
	}
   
}
