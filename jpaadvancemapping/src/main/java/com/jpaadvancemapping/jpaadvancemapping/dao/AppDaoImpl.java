package com.jpaadvancemapping.jpaadvancemapping.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpaadvancemapping.jpaadvancemapping.entity.Instructor;
import com.jpaadvancemapping.jpaadvancemapping.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

	@Autowired
	private EntityManager em;
	public AppDaoImpl(EntityManager eman) {
		em=eman;
	}
	
	@Override
	@Transactional
	public void save(Instructor instructor) {
		em.persist(instructor);
	}

	@Override
	public Instructor findById(int id) {
		return em.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Instructor i=em.find(Instructor.class, id);
		em.remove(i);;
		
	}

	@Override
	@Transactional
	public void deleteInstructorDetails(int id) {
		InstructorDetails instructorDetails=em.find(InstructorDetails.class, id);
		em.remove(instructorDetails);
		
	}

}
