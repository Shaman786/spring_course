package com.springcourse.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springcourse.cruddemo.dao.StudentDAO;
import com.springcourse.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
//        create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "Daffy@gmail.com");
//        save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
//        display id of the save student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
//        retrieve student based on the id: Primary key
		System.out.println("Retrieving student with id");
		Student myStudent = studentDAO.findBYId(theId);
//        display student
		System.out.println("Found the student: " + myStudent);
	}

//	private void createMultipleStudents(StudentDAO studentDAO) {
//		// create multiple students
//		System.out.println("Creating 3 student objects ...");
//		Student tempStudent1 = new Student("reayaz", "Hossain", "reyaz@gmail.com");
//		Student tempStudent2 = new Student("John", "Doe", "John@gmail.com");
//		Student tempStudent3 = new Student("Jane", "Doe", "Jane@gmail.com");
//		// save the student objects
//		System.out.println("Saving the students ...");
//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);
//	}
//
//	private void createStudent(StudentDAO studentDAO) {
//		// create the student object
//		System.out.println("Creating new student object ...");
//		Student tempStudent = new Student("Fayaj", "Hossain", "fayazhossain88@gmail.com");
//		// save the student object
//		System.out.println("Saving the student ...");
//		studentDAO.save(tempStudent);
//		// display id of saved student
//		System.out.println("Saved student. Generated id: " + tempStudent.getId());
//	}
//
//}
}
