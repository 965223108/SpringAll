package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.beans.Car;

@Repository
public class CarDao extends BaseDao<Car>{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("正在保存car....");
	}

}
