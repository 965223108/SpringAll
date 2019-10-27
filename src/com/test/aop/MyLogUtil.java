package com.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 切面类
 */
@Component
@Aspect
public class MyLogUtil {
	
	@Before(value = "execution(public int com.test.aop.MyCalculate.add(int,int))")//在目标方法执行之前,前置通知
	public static void logStart()
	{
		System.out.println("start....");
	}
	@After(value = "execution(public int com.test.aop.MyCalculate.*(int,int))")//在目标方法执行结束之后，后置通知
	public static void logEnded()
	{
		System.out.println("ended....");
	}
	@AfterReturning(value = "execution(public int com.test.aop.MyCalculate.*(int,int))")   //目标方法正常返回，放回通知
	public static void logSuccess()
	{
		System.out.println("execute success....");
	}
	@AfterThrowing(value = "execution(public int com.test.aop.MyCalculate.dev(int,int))")//在目标方法抛出异常之后，异常通知
	public static void logException()
	{
		System.out.println("execute exception....");
	}
	
	public static void logall()
	{
		System.out.println("start all....");
	}

}
