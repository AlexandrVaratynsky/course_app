package com.andersen.course.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "result")
	private double result;
	
	@Column(name = "check")
	private boolean check;

	@Column(name = "question")
	private double question;

	@Column(name = "answer")
	private double answer;

//	@Column(name = "subgroup")
//	private int subgroup;


	@Override
	public String toString() {
		return "Student{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return firstname;
	}
	public void setName(String name) {
		this.firstname = name;
	}
	public String getSurname() {
		return lastname;
	}
	public void setSurname(String surname) {
		this.lastname = surname;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}

}
