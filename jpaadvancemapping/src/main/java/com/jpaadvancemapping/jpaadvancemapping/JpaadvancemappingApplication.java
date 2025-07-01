package com.jpaadvancemapping.jpaadvancemapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpaadvancemapping.jpaadvancemapping.dao.AppDao;
import com.jpaadvancemapping.jpaadvancemapping.entity.Instructor;
import com.jpaadvancemapping.jpaadvancemapping.entity.InstructorDetails;

@SpringBootApplication
public class JpaadvancemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaadvancemappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandRunner(AppDao appDao) {
		return runner->{
//			createInstructor(appDao);
//			findByInstructorId(appDao);
//			deleteInstructor(appDao);
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId=2;
		appDao.deleteInstructorDetails(theId);
		System.out.println("Done!");
		
	}

	private void deleteInstructor(AppDao appDao) {
		int theId=1;
		appDao.delete(theId);
		System.out.println("Successfully Deleted");
		
	}

	private void findByInstructorId(AppDao appDao) {
		int theId=1;
		Instructor instructor=appDao.findById(theId);
		System.out.println("Info: "+instructor);
		
	}

	private void createInstructor(AppDao appDao) {
		
		Instructor theInstructor=new Instructor("Om","phule","om@gmail.com");
		
		InstructorDetails is=new InstructorDetails("www.youTube.com","Cricket");
		
		theInstructor.setInstructorDetails(is);
		
		System.out.println("All Details: "+theInstructor);
		
		appDao.save(theInstructor);
		
		System.out.println("Done!");
		
	}

}
