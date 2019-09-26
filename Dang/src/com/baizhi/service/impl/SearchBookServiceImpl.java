package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.SearchForBookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.SearchBookService;
import com.baizhi.util.MyBatisUtils;

public class SearchBookServiceImpl implements SearchBookService {
	SqlSession sqlSession = null;
	SearchForBookDao dao = null;
	@Override
	public List<Book> TestshowPageSearchBook(int page, int rows,
			Integer category_id) {
		List<Book> b = new ArrayList();
		Integer begin=(page-1)*rows+1;
		Integer end = page*rows;
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(SearchForBookDao.class);
			b = dao.showPageSearchBook(category_id, begin, end);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return b;
	}
	@Override
	public Integer TestcountBook(Integer categoryId) {
		int i =0;
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(SearchForBookDao.class);
			i = dao.count1(categoryId);
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
