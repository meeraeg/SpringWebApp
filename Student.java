package com.student;

import java.util.List;

import org.springframework.boot.orm.jpa.EntityScan;

@EntityScan
public class Student {

	private String name;
	private int age;
	private int id;
	private List<Student> listStudent;
	
	public List<Student> getListStudent() {
		return listStudent;
	}
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
