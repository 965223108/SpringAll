package com.test.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
 * 在对象初始化对象前后调用
 * 单例：
 * 容器启动（构造方法）-->后置处理器before-->对象初始化方法（可有可无）-->后置处理器after--->容器关闭（销毁方法）
 * 多实例：
 * 容器启动（构造方法）-->后置处理器before-->对象初始化方法（可有可无）-->后置处理器after--->容器关闭
 */
public class MyBeanPostPrecessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("对象初始化之前调用--->"+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("对象初始化之后调用-->"+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	

}
