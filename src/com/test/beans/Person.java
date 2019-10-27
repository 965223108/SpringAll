package com.test.beans;


import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sound.sampled.LineListener;

public class Person {
	
	private String userName;
	private String userSex;
	private String userEmail;
	private Integer userAge;
	private Car car;
	private List<Book> books;
	private Map<String, Object> map;
	private Properties properties;
	
	public Person()
	{
		System.out.println("无参构造器调用。。。");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", userSex=" + userSex + ", userEmail=" + userEmail + ", userAge="
				+ userAge + ", car=" + car + ", books=" + books + ", map=" + map + ", properties=" + properties + "]";
	}
	
	
	
	
}
