package com.test.beans;

public class CarInstanceFactory {
	
	public Car getCar(String car_name,Integer car_price,String car_color)
	{
		Car car=new Car();
		car.setCar_name(car_name);
		car.setCar_color(car_color);
		car.setCar_price(car_price);
		return car;
	}

}
