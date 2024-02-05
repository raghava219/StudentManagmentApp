package com.raghava.sms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raghava.sms.entity.Student;
import com.raghava.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handle method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {

        String jacksonData = null;
        
        Map<String, Integer> dataValuePair = new HashMap<String, Integer>();
        dataValuePair.put("Venezuela", 290);
        dataValuePair.put("Saudi", 260);
        dataValuePair.put("Canada", 180);
        dataValuePair.put("Iran", 140);
        dataValuePair.put("Russia", 115);
        dataValuePair.put("UAE", 100);
        dataValuePair.put("US", 30);
        dataValuePair.put("China", 30);

        ObjectMapper objectMapper = new ObjectMapper();

		try {
			jacksonData = objectMapper.writeValueAsString(dataValuePair);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        model.addAttribute("fusionChart", jacksonData);
		
		model.addAttribute("students", studentService.getAllStudents());

		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student",student);
		
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
	
		model.addAttribute("student",studentService.getStudentById(id));
		
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student,
			Model model) {

		//get student from database by id
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}

	//handler method to handle delete request.
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
