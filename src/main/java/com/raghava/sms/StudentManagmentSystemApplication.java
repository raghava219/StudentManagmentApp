package com.raghava.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghava.sms.respository.StudentRepository;

@SpringBootApplication
public class StudentManagmentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		/*
		 * Student student1 = new Student("Rames1", "Kumar1", "Ramesh1@gmail.com");
		 * studentRepo.save(student1);
		 * 
		 * Student student2 = new Student("Rames2", "Kumar2", "Ramesh2@gmail.com");
		 * studentRepo.save(student2);
		 * 
		 * Student student3 = new Student("Rames3", "Kumar3", "Ramesh3@gmail.com");
		 * studentRepo.save(student3);
		 */
	}

}
