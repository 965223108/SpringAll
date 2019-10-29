package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.Calculate;
import com.test.aop.MyCalculate;
import com.test.aop.MyCalculateByCglib;
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
		//细节：容器中的切面对象是一个代理对象，获取这样的对象需要用接口类型获取
		//Calculate calculate = iocApplicationContext.getBean(Calculate.class);
		//calculate.add(1, 2);
		//System.out.println(calculate.getClass());
		//没有接口就是本类类型
		MyCalculateByCglib  myCalculateByCglib = iocApplicationContext.getBean(MyCalculateByCglib.class);
		myCalculateByCglib.add(1, 2);
		System.out.println(myCalculateByCglib);
		/*
		 * 细节二：
		 * * 表示通配符，匹配一个或者 多个
		 * .. 匹配任意多个字符，还可以匹配任意多层路径
		 * && 表示要切入的位置要满足所有的匹配
		 * || 满足任意一个就可以
		 * ！ 只要不是这个位置
		 * 权限位置不写表示任意权限，不能用*
		 * 细节三：
		 * 通知方法的 执行顺序：
		 * 正常执行 before-->after-->afterReturn
		 *异常执行before-->after-->afterThrowing
		 *try{
		 *     @Before
		 *     method.invoke(obj,args);
		 *     @afterReturning
		 *}cathc(Exception e)
		 *{
		 *   @afterThrowing
		 *}finally{
		 *   @after
		 *}
		 *细节4：在 通知方法中拿到目标的详细信息
		 *只需要在通知方法的参数上写一个参数： joinPoint 这个
		 *细节5：
		 *通知方法是spring通过反射调用过的，注意不要乱写参数
		 * 
		 */
				
				
	}

}
