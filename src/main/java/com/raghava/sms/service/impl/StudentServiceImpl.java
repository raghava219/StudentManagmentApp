package com.raghava.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raghava.sms.entity.Student;
import com.raghava.sms.respository.StudentRepository;
import com.raghava.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {


	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long Id) {
		return studentRepo.findById(Id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Long Id) {
		studentRepo.deleteById(Id);
	}
	
	

}
