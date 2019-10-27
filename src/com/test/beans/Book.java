package com.test.beans;

public class Book {
	
	private String book_name;
	private Integer book_price;
	private String book_auther;
	
	/*单实例：
	 * 容器启动（构造器）-->调用容器的初始化方法-->容器关闭（调用对象的销毁方法）
	 * 多实例：
	 * 获取对象（构造器-->初始化方法）-->容器关闭不会调用销毁方法
	 */
	public void bookInit()
	{
		System.out.println("book init......");
	}
	public void bookDestry()
	{
		System.out.println("book destry.....");
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getBook_price() {
		return book_price;
	}
	public void setBook_price(Integer book_price) {
		this.book_price = book_price;
	}
	public String getBook_auther() {
		return book_auther;
	}
	public void setBook_auther(String book_auther) {
		this.book_auther = book_auther;
	}
	@Override
	public String toString() {
		return "Book [book_name=" + book_name + ", book_price=" + book_price + ", book_auther=" + book_auther + "]";
	}
	

}
