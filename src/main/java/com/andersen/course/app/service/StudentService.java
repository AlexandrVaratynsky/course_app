package com.andersen.course.app.service;

import java.util.List;
import com.andersen.course.app.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public void saveStudent(Student student);
	public Student getStudent(int id);
	public void deleteStudent(int id);
}
