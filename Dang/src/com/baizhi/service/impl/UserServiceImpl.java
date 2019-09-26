package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MyBatisUtils;

public class UserServiceImpl implements UserService {
	SqlSession sqlSession = null;
	UserDao dao = null;
	@Override
	public User login(User u) {
		User u1 = new User();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(UserDao.class);
			u1=dao.selectOne(u);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return u1;
	}

	@Override
	public void register(User u) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(UserDao.class);
			dao.insert(u);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		
	}

	@Override
	public void updateState(User u) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(UserDao.class);
			dao.updateState(u);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		
	}

}
