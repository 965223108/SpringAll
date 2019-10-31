package com.test.transition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public boolean checkout(int acount_id,int good_id,int goods_size)
	{
		double goodPrice = userDao.getGoodsPrice(good_id);
		userDao.updateBalance(acount_id, goodPrice, goods_size);
		userDao.updateGoodsStrage(good_id, goods_size);
		return false;
	}
	

}
