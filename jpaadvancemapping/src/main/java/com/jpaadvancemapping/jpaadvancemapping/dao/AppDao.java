package com.jpaadvancemapping.jpaadvancemapping.dao;

import com.jpaadvancemapping.jpaadvancemapping.entity.Instructor;

public interface AppDao {

	void save(Instructor instructor);
	
	Instructor findById(int id);
	
	void delete(int id);
	
	void deleteInstructorDetails(int id);
}
