package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.SearchForBookDao;
import com.baizhi.entity.Book;
import com.baizhi.util.MailUtil;
import com.baizhi.util.MyBatisUtils;

public class SearchBook {
		SqlSession sqlSession = null;
		SearchForBookDao sf = null;
		@Test
		public void TestshowPageSearchBook(){
			sqlSession = MyBatisUtils.getSqlSession();
			sf = sqlSession.getMapper(SearchForBookDao.class);
			List<Book> b =new ArrayList();
			b = sf.showPageSearchBook(6, 1, 9);
			for(Book b1:b){
				System.out.println(b1);
			}
			sqlSession.close();
		}
		@Test
		public void TestcountBook(){
			sqlSession = MyBatisUtils.getSqlSession();
			sf = sqlSession.getMapper(SearchForBookDao.class);
			/*List<Book> b =new ArrayList();*/
			int i =0;
			i = sf.count1(6);
				System.out.println(i);
			sqlSession.close();
		}
	@Test
	public void Mail(){
		int i =0;
		i=MailUtil.sendSimpleMail("3070124783@qq.com");
		System.out.println(i);
	}
}
