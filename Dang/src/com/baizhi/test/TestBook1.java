package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.SearchForBookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MyBatisUtils;

public class TestBook1 {
	SqlSession sqlSession = null;
	SearchForBookDao dao = null;
	@Test
	public void showPageSearchBooks(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(SearchForBookDao.class);
		Book b= new Book();
		List<Book> b1 = new ArrayList();
		b.setBookName("Í¯Äê");
		b1=dao.showPageSearchBooks(b.getBookName(), 1, 3);
		System.out.println(b1);
		sqlSession.close();
	}
	@Test
	public void showPageSearchBooks1(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(SearchForBookDao.class);
		Book b= new Book();
		List<Book> b1 = new ArrayList();
		int i =0;
		b.setBookName("Í¯Äê");
		i=dao.count(b.getBookName());
		System.out.println(i);
		sqlSession.close();
	}
}
