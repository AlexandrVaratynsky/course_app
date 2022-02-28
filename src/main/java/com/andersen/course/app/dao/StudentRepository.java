package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
