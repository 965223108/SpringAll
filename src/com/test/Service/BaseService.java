package com.test.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.BaseDao;

public class BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;
	
	public void save()
	{
		baseDao.save();
	}

}
