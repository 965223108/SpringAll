package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Service.BaseService;
import com.test.Service.BookService;
import com.test.Service.CarService;
import com.test.beans.Book;
import com.test.beans.Car;


/*
 * spring的单元测试包
 * 1.导入spring-text包
 * 指定spring配置文件classpath
 * 使用@RunWith使用spring-test测试框架
 */
@ContextConfiguration(locations = "classpath:SpringApplication.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestMain {
	
	@Autowired
	private DataSource DataSource;
	@Autowired
	private BookService bookService;
	@Autowired
	private CarService CarService;
	
	@Test
	public void test01() throws SQLException
	{
		Connection connection =  DataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}
	
	@Test
	public void test02()
	{
		bookService.save();
		CarService.save();
	}
	
	

}
