package com.test.transition;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * timeout（单位 秒）: 表示事务执行时间，如果超过时间则事务回滚
 * readOnly: 只读属性，如果事务都是读操作这个配置可以优化
 * 异常时候：
 * 		运行时异常默认会回滚，编译异常默认不回滚
 * noRollbackFor(noRollbackForClassName)： 哪些异常可以不回滚（可以让原本默认回滚的异常不回滚）
 * 
 * rollbackFor:那些异常需要回滚（可以让原本默认不回滚的异常回滚）
 * 
 * isolation:隔离级别
 * 			1. 脏读
 * 			2.不可重复读
 *          3.幻读
 * 有事务逻辑的对象在容器中保存的是代理对象
 * 
 * 事务的传播，行为：如果有多个事务嵌套运行，子事务是否要和大事务公用一个事务
 * 			1.required:如果有事务运行，当前方法在事务中运行，如果没有就自己开一个事务 （常用）
 * 			3.supports: 如果有事务就在事务中运行，如果没有就不要事务
 * 			2.required_new：当前方法必须放在自己的事务中运行，如果有其他 事务在运行就应该将当前事务挂起（常用）
 * 			4.not_supports: 当前方法不应该运行在事务中，如果有事务就将事务挂起
 *          5.mandatory： 当前方法必须放在事务中运行，如果没有正在运行的事务就抛出异常
 *          6.never：当前方法必须运行在事务中，如果没有正在运行的事务就抛出异常
 *          7.nested:如果 有事务在运行，当前的方法就应该在这个事务的嵌套事务运行，否则就启动一个新的事务并在它自己的事务中运行 （需要环境支持） 
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional(timeout = 10,readOnly = false,
			       noRollbackFor = {ArithmeticException.class,NullPointerException.class}
	               ,noRollbackForClassName = {"java.lang.ArithmeticException"}
	               ,rollbackFor = {FileNotFoundException.class}
	               ,isolation = Isolation.READ_COMMITTED
	               ,propagation = Propagation.REQUIRED
	               )
	public boolean checkout(int acount_id,int good_id,int goods_size)
	{
		double goodPrice = userDao.getGoodsPrice(good_id);
		userDao.updateBalance(acount_id, goodPrice, goods_size);
		userDao.updateGoodsStrage(good_id, goods_size);
		acount_id=10/0;
		return false;
	}
	

}
