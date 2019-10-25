package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Person;

public class TestMain {
	
	@Test
	public void test01()
	{
		ApplicationContext ioc =new ClassPathXmlApplicationContext("SpringApplication.xml");
		Person person = (Person)ioc.getBean("p1");
		//Person person1 = ioc.getBean(Person.class);
		Person person2 = ioc.getBean("p4",Person.class);
		System.out.println(person2);
	}
	

}
