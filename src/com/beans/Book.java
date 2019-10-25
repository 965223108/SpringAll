package com.beans;

public class Book {
	
	private String book_name;
	private Integer book_price;
	private String book_auther;
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
