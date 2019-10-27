package com.test.beans;

public class CarStaticFactory {
	
	public static Car getCar(String car_name,Integer car_price,String Car_color)
	{
		Car car=new Car();
		car.setCar_name(car_name);
		car.setCar_color(Car_color);
		car.setCar_price(car_price);
		return car;
	}
}
