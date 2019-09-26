package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.SearchForBookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService1;
import com.baizhi.util.MyBatisUtils;

public class BookServiceImpl1 implements BookService1 {
	SqlSession sqlSession = null;
	SearchForBookDao dao =null;
	@Override
	public List<Book> showPageSearchBooks(String BookName, Integer page, Integer rows) {
		Integer begin = (page-1)*rows+1;
		Integer end = page*rows;
		List<Book> bo = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(SearchForBookDao.class);
			bo= dao.showPageSearchBooks(BookName, begin, end);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return bo;
	}
	@Override
	public Integer count(String BookName) {
		int i =0;
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(SearchForBookDao.class);
			i= dao.count(BookName);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return i;
	}
	

}
