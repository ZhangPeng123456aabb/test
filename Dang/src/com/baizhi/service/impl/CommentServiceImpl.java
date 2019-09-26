package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.CommentDao;
import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import com.baizhi.util.MyBatisUtils;

public class CommentServiceImpl implements CommentService {
	SqlSession sqlSession  =  null;
	CommentDao dao = null;
	@Override
	public void insertComment(Comment com) {
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CommentDao.class);
			dao.insertComment(com);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		
	}

	@Override
	public List<Comment> selectComment(Integer BookId) {
		List<Comment> com = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(CommentDao.class);
			com = dao.selectComment(BookId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return com;
	}

}
