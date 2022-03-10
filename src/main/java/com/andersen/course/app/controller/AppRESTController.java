package com.andersen.course.app.controller;

import com.andersen.course.app.service.StudentService;
import java.util.List;
import com.andersen.course.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppRESTController {
	
	@Autowired
	private StudentService  studentService;


	
	@GetMapping("/students")
	public List<Student> showAllStudents(){
		List<Student> allStudents = studentService.getAllStudents();
		return allStudents;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentService.getStudent(id);
		
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "student " + id + " was deleted";
	}
}
