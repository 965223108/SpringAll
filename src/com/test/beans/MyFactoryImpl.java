package com.test.beans;

import org.springframework.beans.factory.FactoryBean;

/*
 * 实现了 spring FactoryBean接口的对象都会被spring 默认为工厂对象
 * ioc容器启动的时候不会自动创建
 */
public class MyFactoryImpl implements FactoryBean<Book>{

	@Override
	public Book getObject() throws Exception {
		// TODO Auto-generated method stub
		Book book=new Book();
		book.setBook_name("mybookname");
		book.setBook_auther("noname");
		book.setBook_price(100);
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;
	}

}
