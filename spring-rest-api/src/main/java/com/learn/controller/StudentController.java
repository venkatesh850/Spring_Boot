package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bean.Student;

//converting student object into json 
@RestController
public class StudentController {
	
	//http://localhost:8080/students
	@GetMapping("/students")
	public Student getStudents() {
		Student student = new Student(
				1, "Venkatsh", "K"
			);
		return student;
	}

}
