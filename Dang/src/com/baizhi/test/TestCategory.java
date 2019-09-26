package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.CategoryDao;
import com.baizhi.dao.CategoryDao1;
import com.baizhi.dao.SearchForBookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.util.MyBatisUtils;

public class TestCategory {
	SqlSession sqlSession = null;
	CategoryDao dao = null;
	CategoryDao1 dao1 = null;
	@Test
	public void TestshowCategory(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		Category ca = new Category();
		List<Category> ct = new ArrayList();
		 ct= dao.showCategory();
		 for(Category ca1:ct){
			System.out.println(ca1.getCategory_name());
			List<Category> ca2 = ca1.getCategory();
			for(Category c1:ca2){
				System.out.println("  "+c1.getCategory_name());
			}
		 }
	}
	@Test
	public void TestSelectCategories(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		Category ca = new Category();
		Category t = new Category();
		ca = dao.SelectCategories(1);
			System.out.println(ca.getCategory_name());
			List<Category> c1 = ca.getCategory();
			for(Category s1:c1){
				System.out.println(s1.getCategory_name());
			}
	}
	@Test
	public void TestshowBooks(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		List<Book> b = new ArrayList<>();
		Category ca = new Category();
		b=dao.showBooks(1);
		System.out.println(b);
			System.out.println(ca.getCategory_name());
			b=ca.getBooklist();
			for(Book k:b){
			System.out.println(k);
			}
		sqlSession.close();
	}
	@Test
	public void TestshowCategory2(){
		int i = 0 ;
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		i = dao.showCategory1(6);
		System.out.println(i);
		sqlSession.close();
	}
	@Test
	public void TestshowCategory4(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		List<Book> b = new ArrayList<>();
		Category c = new Category();
		int i=dao.selectByPage1(6);
		System.out.println(i);
		sqlSession.close();
	}
	@Test
	public void selectCategory(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao1 = sqlSession.getMapper(CategoryDao1.class);
		Book b= new Book();
		b.setBookId(6);
		List<Book> b1 = new ArrayList();
		Category ca = new Category();
		ca=dao1.selectCategory(b);
			System.out.println(ca.getCategory_name());
			List<Category> b3 = ca.getCategory();
			for(Category ca1:b3){
				System.out.println("  "+ca1.getCategory_name());
			}
		sqlSession.close();
	}
	@Test
	public void TestshowCategory5(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CategoryDao.class);
		Category c = new Category();
		c=dao.selectCategory(11);
		System.out.println(c.getCategory_name());
		List<Category> ca = new ArrayList();
		ca=c.getCategory();
		for(Category c1:ca){
			System.out.println(c1.getCategory_name());
		}
		sqlSession.close();
	}
}
