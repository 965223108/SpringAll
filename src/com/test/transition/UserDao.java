package com.test.transition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate userTemplate;
	
	/*
	 * 更新用户余额
	 */
	public void updateBalance(int acount_id,Double goods_price,int goods_size)
	{
		double totalprice = goods_price  * goods_size;
		String sqlString = "UPDATE user_count set balance=balance-? where uid=? ";
		int result = userTemplate.update(sqlString, totalprice,acount_id);
		System.out.println("更新余额: " + String.valueOf(result > 0));
	}
	
	/*
	 * 根据商品id号查询商品价格
	 */
	public double getGoodsPrice(int goods_id)
	{
		String sqlString="select g_price from goods where g_id=?";
		return userTemplate.queryForObject(sqlString, int.class,goods_id);
	}
	/*
	 * 更新商品库存
	 */
	public void updateGoodsStrage(int goods_id,int goods_count)
	{
		String sqlString="update goods_storage set g_storage = g_storage-? where g_id=? ";
		int result = userTemplate.update(sqlString, goods_count,goods_id);
		System.out.println("更新库存状态："+ String.valueOf(result > 0));
	}

}
