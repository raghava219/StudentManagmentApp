package com.raghava.sms.service;

import java.util.List;

import com.raghava.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long Id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long Id);

}
