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

	@Column(name = "subgroup")
	private int subgroup;


	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", result=" + result +
				", check=" + check +
				", question=" + question +
				", answer=" + answer +
				", subgroup=" + subgroup +
				'}';
	}

	public int getId() {

		return id;
	}
	public void setId(int id) {

		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public double getQuestion() {
		return question;
	}

	public void setQuestion(double question) {
		this.question = question;
	}

	public double getAnswer() {
		return answer;
	}

	public void setAnswer(double answer) {
		this.answer = answer;
	}

	public int getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(int subgroup) {
		this.subgroup = subgroup;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
