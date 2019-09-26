package com.baizhi.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.CommentDao;
import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import com.baizhi.service.impl.CommentServiceImpl;
import com.baizhi.util.MyBatisUtils;

public class TestComment {
	SqlSession sqlSession = null;
	CommentDao dao = null;
	@Test
	public void TestinsertComment(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CommentDao.class);
		Comment com = new Comment();
		com.setCommentContent("Ê®¶þÊ±³½");
		Date date = new Date();
		com.setCommentDate(date);
		com.setCommentFloor(3);
		com.setBookId(13);
		com.setUserId(1);
		dao.insertComment(com);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void TestSelectComment(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CommentDao.class);
		List<Comment> com = new ArrayList();
		Comment c = new Comment();
	    com = dao.selectComment(13);
		System.out.println(com);
		sqlSession.close();
	}
	@Test
	public void TestSelectComment1(){
		CommentService cs = new CommentServiceImpl();
		List<Comment> com = new ArrayList();
		com = cs.selectComment(26);
		System.out.println(com);
	}
}
