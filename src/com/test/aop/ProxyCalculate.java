package com.test.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ProxyCalculate {

	public static Calculate getCalculate(final Calculate class1) {
		
		ClassLoader loader=class1.getClass().getClassLoader();
		Class<?>[] interfaces=class1.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			/*
			 * proxy 参数是给jdk使用的，这儿 不能用
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object resultObject=null;
				try {
					System.out.println("方法："+method.getName()+">开始执行===> " +Arrays.asList(args));
					resultObject = method.invoke(class1, args);
					System.out.println("方法："+method.getName()+">正常结束===> " +Arrays.asList(args));
				}catch (Exception e) {
					System.out.println("方法："+method.getName()+">执行异常===> " +e.getCause());
				}finally {
					System.out.println("方法："+method.getName()+">结束,结果===> "+resultObject);
				}
				return resultObject;
			}
		};
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return (Calculate) proxyObject;
	}
	

}
