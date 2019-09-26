package com.baizhi.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MyBatisUtils;

public class TestUser {
	SqlSession sqlSession = null;
	UserDao dao = null;
	@Test
	public void TestSelectOne(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(UserDao.class);
		User u = new User();
		u.setEmail("2281306880@qq.com");
		u.setPassword("488965");
		u = dao.selectOne(u);
		System.out.println(u);
		sqlSession.close();
	}
	@Test
	public void TestInsert(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(UserDao.class);
		User u = new User();
		u.setId(6);
		u.setEmail("123445@qq.com");
		u.setNickname("хавЃзг");
		u.setState(1);
		u.setPassword("488988");
		 dao.insert(u);
		sqlSession.commit();
		sqlSession.close();
	}
}
