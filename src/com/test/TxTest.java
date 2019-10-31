package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans.Person;
import com.test.transition.UserService;

public class TxTest {
	
	@Test
	public void test01()
	{
		ApplicationContext ioc = new ClassPathXmlApplicationContext("SpringApplication.xml");
		UserService userService = ioc.getBean(UserService.class);
		userService.checkout(2, 2, 2);
	}
	@Test
	@SuppressWarnings("resource")
	public void testIOC()
	{
		ApplicationContext ioc = new ClassPathXmlApplicationContext("SpringApplication.xml");
		Person person = ioc.getBean("p1",Person.class);
		System.out.println(person);
	}

}
