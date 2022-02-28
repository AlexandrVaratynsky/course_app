package com.andersen.course.app.service;

import java.util.List;
import java.util.Optional;
import com.andersen.course.app.entity.Student;
import com.andersen.course.app.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);

	}

	@Override
	public Student getStudent(int id) {
		Student student = null;
		Optional<Student> emp = studentRepository.findById(id);
		if (emp.isPresent()) {
			student = emp.get();
		}
		
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);

	}

}
