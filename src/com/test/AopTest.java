package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.Calculate;
import com.test.aop.MyCalculate;
import com.test.aop.ProxyCalculate;

/*
 * 动态代理缺陷：
 * 1.动态代理的对象必须有接口，如果目标对象没有实现任何接口就没法生成代理对象
 */
public class AopTest {
	
	@Test
	public void test()
	{
		Calculate calculate=new MyCalculate();
		Calculate calculateProxy = ProxyCalculate.getCalculate(calculate);
		calculateProxy.dev(1, 1);
	}
	
	@Test
	public void test02()
	{
		ApplicationContext iocApplicationContext = new ClassPathXmlApplicationContext("SpringApplication.xml");
		Calculate calculate = iocApplicationContext.getBean(Calculate.class);
		calculate.add(1, 2);
	}

}
