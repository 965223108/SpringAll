package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.test.beans.Person;

public class JdbcTemplateTest {
	
	/*
	 * 测试jdbcTemplate
	 */
	@Test
	public void test01()
	{
		ApplicationContext iocApplicationContext = new ClassPathXmlApplicationContext("SpringApplication.xml");
		//DataSource dataSource  = iocApplicationContext.getBean(DataSource.class);
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//System.out.println(jdbcTemplate);
		JdbcTemplate jdbcTemplate = iocApplicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
		System.out.println(jdbcTemplate);
		
		//更新一条记录
		String sql ="update user set uname=?,sex=? where id=?";
		jdbcTemplate.update(sql, "xiaoli","1",1);
		//批量操作
		String intoSqlString = "insert into user(uname,sex) values(?,?)";
		List<Object> argsList = new ArrayList<Object>();
		argsList.add(new Object[] {"xiaoming",1});
		argsList.add(new Object[] {"xiaohua",0});
		int[] resutl = jdbcTemplate.batchUpdate(intoSqlString, (BatchPreparedStatementSetter) argsList);
		
		//查询数据并封装成对象,无论查询单个 数据还是单个对象都是使用queryForObject
		//查询单个结果，如果查询结果为空会报错，最好try一下
		String selectSql = "select * from user where id=?";
		RowMapper<Person> requiredType = new BeanPropertyRowMapper<Person>();
		Person person = jdbcTemplate.queryForObject(selectSql, requiredType, 1);
		List<Person> persons = jdbcTemplate.query(selectSql, requiredType);
		
	}
	
	@Test
	public void test02()
	{
		ApplicationContext iocApplicationContext = new ClassPathXmlApplicationContext("SpringApplication.xml");
		JdbcTemplate jdbcTemplate = iocApplicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
		
		String sqlString="select count(*) from user";
		Integer resInteger = jdbcTemplate.queryForObject(sqlString, Integer.class);
		System.out.println(resInteger);
		//使用具名模板操作
		NamedParameterJdbcTemplate namedTemplate = iocApplicationContext.getBean(NamedParameterJdbcTemplate.class);
		String namedSqlInsertString = "insert into user(uname,sex) values(:uname,:sex)";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("uname", "xiaoming");
		paraMap.put("sex", "0");
		int result = namedTemplate.update(namedSqlInsertString, paraMap);
		System.out.println("插入操作："+result);
		////////////////////////////////////////////
		Person person=new Person();
		person.setUserName("usernametest");
		SqlParameterSource parametersource=new BeanPropertySqlParameterSource(person);
		namedTemplate.update(namedSqlInsertString, parametersource);
		
		
	}

}
