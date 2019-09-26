package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.dao.CategoryDao1;
import com.baizhi.entity.BeginEnd;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.MyBatisUtils;

public class CategoryServiceImpl implements CategoryService {
	SqlSession sqlSession = null;
	CategoryDao dao = null;
	CategoryDao1 dao1=null;
	BookDao bao = null;
	@Override
	public List<Category> showAllCategory() {
		List<Category> ca = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			ca=dao.showCategory();
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return ca;
	}
	@Override
	public List<Book> showBooks(Integer category_id) {
		List<Book> b = new ArrayList<>();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			b=dao.showBooks(category_id);
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
	public Category SelectCategories(Integer parent_id) {
		Category ca = new Category();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			ca=dao.SelectCategories(parent_id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return ca;
	}
	@Override
	public Category selectByPage(int page, int rows,Integer category_id) {
		Category ca = new Category();
		BeginEnd Be = new BeginEnd();
		int begin = (page-1)*rows+1;
		int end = page*rows;
		Be.setBegin(begin);
		Be.setEnd(end);
		System.out.println(Be);
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
		   ca = dao.selectByPage(end, begin, category_id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return ca;
	}
	@Override
	public Integer showCategory1(Integer category_id) {
		Integer i =null;
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			i=dao.showCategory1(category_id);
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
	public List<Book> selectAllBooks(int page, int rows,Integer category_id) {
		List<Book> b = new ArrayList<>();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			b=bao.selectAllBooks(page,rows,category_id);
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
	public Integer selectByPage1(Integer category_id) {
		int i = 0 ;
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			i=dao.selectByPage1(category_id);
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
	public Category selectCategory(Book b) {
		Category ca = new Category();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao1 = sqlSession.getMapper(CategoryDao1.class);
			ca=dao1.selectCategory(b);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return ca;
	}
	@Override
	public Category selectCategory1(Integer BookId) {
		Category category = new Category();
		List<Category> ca = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CategoryDao.class);
			category = dao.selectCategory(BookId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return category;
	}

}
