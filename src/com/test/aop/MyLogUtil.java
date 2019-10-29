package com.test.aop;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类
 */
@Component
@Aspect
public class MyLogUtil {
	/*
	 * 抽取可重用的切入点
	 */
	@Pointcut(value = "execution(public int com.test.aop.MyCalculate.add(int,int))")
	public void myPointCut() {
		// TODO Auto-generated method stub

	}
	
	@Before(value = "myPointCut()")//在目标方法执行之前,前置通知
	public static void logStart()
	{
		System.out.println("start....");
	}
	@After(value = "execution(public int com.test.aop.MyCalculate.*(int,int))")//在目标方法执行结束之后，后置通知
	public static void logEnded()
	{
		System.out.println("ended....");
	}
	@AfterReturning(value = "execution(public int com.test.aop.MyCalculate.*(int,int))",returning ="result")   //目标方法正常返回，放回通知
	public static void logSuccess(JoinPoint joinPoint,Object result)
	{
		System.out.println("execute success....");
	}
	@AfterThrowing(value = "execution(public int com.test.aop.MyCalculate.dev(int,int))",throwing = "e")//在目标方法抛出异常之后，异常通知
	public static void logException(JoinPoint joinPoint,Exception e)
	{
		System.out.println("execute exception....");
	}
	
	//使用cglib生成代理类
	@After(value = "execution(public int com.test.aop.MyCalculateByCglib.*(int,int))")
	public static void logCglib(JoinPoint joinPoint)
	{
		Object[] argsObjects = joinPoint.getArgs();
		String method_nameString = joinPoint.getSignature().getName();
		System.out.println(Arrays.asList(argsObjects));
		System.out.println(method_nameString);
		System.out.println("start cglib all....");
	}
	
	//这个就是一个完整的动态代理过程,环绕通知是优先于普通通知的
	/*
	 * 普通前置
	 * 【】
	 * 普通后置
	 */
	@Around(value = "")
	public static Object logall(ProceedingJoinPoint point) throws Exception
	{
		Object resultObject=null;
		try {
			Object[] argsObjects = point.getArgs();
			resultObject = point.proceed(argsObjects);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("finally ...");
		}
		System.out.println("start all....");
		return resultObject;
	}

}
