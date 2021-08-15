package com.restmvc.model;

public class Client {
	
	private int id;
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
