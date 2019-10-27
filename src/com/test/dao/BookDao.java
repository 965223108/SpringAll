package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.beans.Book;

@Repository
public class BookDao extends BaseDao<Book>{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("正在保存图书。。。");
	}

}
