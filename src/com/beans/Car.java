package com.beans;

public class Car {
	private String car_name;
	private Integer car_price;
	private String car_color;
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public Integer getCar_price() {
		return car_price;
	}
	public void setCar_price(Integer car_price) {
		this.car_price = car_price;
	}
	public String getCar_color() {
		return car_color;
	}
	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}
	@Override
	public String toString() {
		return "Car [car_name=" + car_name + ", car_price=" + car_price + ", car_color=" + car_color + "]";
	}
	
	

}
