package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.MyBatisUtils;

public class BookServiceImpl implements BookService {
	SqlSession sqlSession=null;
	BookDao dao = null;
	List<Book> b = new ArrayList();
	@Override
	public List<Book> selectSales() {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectSales();
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
	public List<Book> selectTime() {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectTime();
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
	public List<Book> selectCount(int i) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectCount(i);
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
	public List<Book> selectAuthor(String Author) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectAuthor(Author);
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
	public List<Book> showAll(String OrderBy, Integer i) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectAll(OrderBy, i);
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
	public List<Book> selectAllBooks(@Param("page")Integer page,@Param("rows")Integer rows,Integer category_id) {
		Integer begin=(page-1)*rows+1;
		Integer end = page*rows;
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectAllBooks(begin,end,category_id);
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
	public Book SelectOneBook(Integer BookId) {
		Book b = new Book();
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectOneBook(BookId);
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
	public Integer CountBooks(Integer category_id) {
		int i =0;
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			i =dao.countBook(category_id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return i;
	}

	@Override
	public List<Book> selectAllBook(@Param("page")Integer page,@Param("rows")Integer rows,Integer category_id) {
		Integer begin=(page-1)*rows+1;
		Integer end = page*rows;
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			b =dao.selectAllBook(begin,end,category_id);
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
	public Integer CountSecondBook(Integer category_id) {
		int i =0;
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(BookDao.class);
			i =dao.countSecondBook(category_id);
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
