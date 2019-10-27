package com.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans.Book;
import com.test.beans.Car;
import com.test.beans.Person;
import com.test.controller.PersonController;

public class TestMain {
	
	
	@Test
	public void test01()
	{
		ApplicationContext ioc =new ClassPathXmlApplicationContext("SpringApplication.xml");
		Book book = (Book)ioc.getBean("book2");
		//Person person1 = ioc.getBean(Person.class);
		Person person2 = ioc.getBean("p9",Person.class);
		Car car=(Car)ioc.getBean("instance_car");
		Book book2 = (Book)ioc.getBean("InterfaceFactoryImpl");
		//System.out.println(car);
		//System.out.println(book);
		System.out.println(person2);
	}
	
	@Test
	public void test02() throws SQLException
	{
		ApplicationContext ioc =new ClassPathXmlApplicationContext("SpringApplication.xml");
		DataSource datasource = ioc.getBean(DataSource.class);
		System.out.println(datasource.getConnection());
	}
	
	@Test
	public void test03()
	{
		ApplicationContext ioc =new ClassPathXmlApplicationContext("SpringApplication.xml");
		PersonController personController = (PersonController)ioc.getBean("pController");
		System.out.println(personController);
	}
	

}
