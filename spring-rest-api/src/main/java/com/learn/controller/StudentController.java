package com.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bean.Student;

//converting student object into json 
@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		Student student = new Student(
				1, "Venkatsh", "K"
			);
		return student;
	}

	//get all the students
	//http://localhost:8080/students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Ramesh","Jadhav"));
		students.add(new Student(2,"Umesh","Yadav"));
		students.add(new Student(3,"Shardul","Thakur"));
		students.add(new Student(4,"Virat","Kohli"));
		return students;
	}
	
	//Spring Boot Rest API with path variable
	//{id} -> URI Template variable
	//http://localhost:8080/student/1
	@GetMapping("/student/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId) {
		return new Student(studentId,"Ramesh","Jadhaw");
	}
	
	//Spring BOOT REST API with RequestParam
	//http://localhost:8080/student/query?id=1&firstName=Ramesh&lastName=jadhaw
	@GetMapping("/student/query")
	public Student studentRequestVariable(@RequestParam int id,
											@RequestParam String firstName,
											@RequestParam String lastName) {
		return new Student(id,firstName,lastName);
	}
	
	//Spring Boot REST API that handles HTTP POST Request
	//@Postmapping and @RequestBody
	
	@PostMapping("/student/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student craeteStudent(@RequestBody Student student) {
		System.out.println(student.getStudentId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName()); 
		return student;
		
	}
	 
	
	//Spring Boot REst API that handles PUT Request
	//using @PostMapping, @PathVariable and @RequestBody
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	//Spring Boot REst API that handles PUT Request
	//using @DeleteMapping and @PathVariable
	//here we just checking if the id is going to the delete mapping
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") int studentId) {
		return "Student deleted successfully";
	}
}
