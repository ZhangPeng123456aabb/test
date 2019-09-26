package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.util.MyBatisUtils;

public class TestBook {
	SqlSession sqlSession = null;
	BookDao dao = null;
	@Test
	public void TestselectSales(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectSales();
		System.out.println(b);
		sqlSession.close();
	}
	@Test
	public void TestselectTime(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectTime();
		System.out.println(b);
		sqlSession.close();
	}
	@Test
	public void TestselectCount(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectCount(10);
		for(Book r:b){
			System.out.println(r.getBookName());
		}
		sqlSession.close();
	}
	@Test
	public void TestselectAuthor(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectAll("up_date", 4);
		System.out.println(b);
		sqlSession.close();
	}
	//×ÛºÏsqlÓï¾ä
	@Test
	public void TestselectAll(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectAll("book_price",4);
		System.out.println(b);
		sqlSession.close();
	}
	@Test
	public void TestselectAuthor1(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList();
		Book b1 =new Book();
		b = dao.selectAuthor("Àî¸Ú");
		System.out.println(b);
		sqlSession.close();
	}
	@Test
	public void TestshowBooks(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList<>();
		b=dao.selectAllBooks(1,5,4);
		System.out.println(b);
		sqlSession.close();
}
	@Test
	public void TestSelectOnerBook(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		/*List<Book> b = new ArrayList<>();*/
		Book b = new Book();
		b=dao.selectOneBook(17);
		System.out.println(b);
		sqlSession.close();
}
	@Test
	public void TestSelectAllBooks(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList<>();
		Book b1 = new Book();
		b=dao.selectAllBooks(1,5,5);
		for(Book c:b){
			System.out.println(c);
		}
		sqlSession.close();
	}
	@Test
	public void TestSelectAllBooks1(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		BookService bs = new BookServiceImpl();
		List<Book> b = new ArrayList<>();
		Book b1 = new Book();
		b=bs.selectAllBooks(1,10,5);
		for(Book c:b){
			System.out.println(c);
		}
		sqlSession.close();
	}
	@Test
	public void TestCountBooks(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		int i=0;
		i = dao.countBook(1);
		System.out.println(i);
	}
	@Test
	public void TestselectAllBook(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		List<Book> b = new ArrayList<>();
		b= dao.selectAllBook(1,10,6);
		for(Book v:b){
			System.out.println(v);
		}
	}
	@Test
	public void TestselectAllBook1(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		BookService bs =new BookServiceImpl();
		List<Book> b = new ArrayList<>();
		b= bs.selectAllBook(1,10,6);
		for(Book v:b){
			System.out.println(v);
		}
	}
	@Test
	public void TestCountSecondBook(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(BookDao.class);
		int i=0;
		i = dao.countSecondBook(6);
		System.out.println(i);
	}
	@Test
	public void TestSelectOnerBook1(){
		BookService bs = new BookServiceImpl();
		Book b = new Book();
		b=bs.SelectOneBook(17);
		System.out.println(b);
		sqlSession.close();
	}
}