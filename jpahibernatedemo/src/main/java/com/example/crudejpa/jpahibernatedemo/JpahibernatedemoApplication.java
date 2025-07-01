package com.example.crudejpa.jpahibernatedemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crudejpa.jpahibernatedemo.dao.StudentDAO;
import com.example.crudejpa.jpahibernatedemo.entity.Student;

@SpringBootApplication
public class JpahibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpahibernatedemoApplication.class, args);
	}
	
//@Bean
//public CommandLineRunner commandLine(String[] args)
//{
//	return runner -> {
//		System.out.println("Hello World");
//	};
//}
	
	
	@Bean
	public CommandLineRunner commandLine(StudentDAO studentDao)
	{
		return runner -> {
//			createStudent(studentDao);
//			readStudent(studentDao);
//			queryForStudents(studentDao);
//			queryFindByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteById(studentDao);
//			deleteAllData(studentDao);
		};
	}
	
	private void deleteAllData(StudentDAO studentDao) {
     System.out.println("Deleting all rows");
     int num=studentDao.deleteAll();
     System.out.println("Deleted number of Rows: "+num);
	
}

	private void deleteById(StudentDAO studentDao) {
	// display that id which is deleted
		int sid=1;
		System.out.println("Deleting id: "+sid);
	//perform deletion
		studentDao.delete(sid);
		System.out.println("Id Deleted.......");
	
}

	private void updateStudent(StudentDAO studentDao) {
	//retrive row using id
		int studentId=1;
		Student myStudent=studentDao.findById(studentId);
	//perform updatation
		myStudent.setFirstName("Sakshi");
		
	//update data
		studentDao.update(myStudent);
		
	//display
		System.out.println("Details: "+myStudent);
	
}

	private void queryFindByLastName(StudentDAO studentDao) {
	//get list of student
		List<Student> students=studentDao.findByLastName("Phule");
		
	//display the student
	    for(Student st:students) {
	    	System.out.println("Details: "+st);
	    }
}

	private void queryForStudents(StudentDAO studentDao) {
	//get list of students
		List<Student> students=studentDao.findAll();
		
	//display the students
		for(Student st:students) {
			System.out.println("Students Details: "+st);
		}
}

	private void readStudent(StudentDAO studentDao) {
	//create the object
		System.out.println("Creating the object....");
		Student mystudent=new Student("Sarthak","Nande","sarthak@gmail.com");
	//save the object
		System.out.println("Saving the object");
		studentDao.save(mystudent);
	//display the id
		System.out.println("Save the id: "+mystudent.getId());
		
	//retrive the object
		System.out.println("Retriving object...");
		Student st=studentDao.findById(mystudent.getId());
		
	//print the object
		System.out.println("Find object: "+st);
	
}

	private void createStudent(StudentDAO studentDao)
	{
		//create the Student Object
		Student theStudent=new Student("Om","Phule","omphule77@gmail.com");
		
		//save that object
		studentDao.save(theStudent);
		
		//display the id 
		System.out.println("Current Id Save: "+theStudent.getId());
		
	}

}
