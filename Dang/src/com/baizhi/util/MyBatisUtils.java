package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession>tl = new ThreadLocal<SqlSession>();
	static{
		try{
			String resource = "mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = tl.get();
		if(sqlSession == null){
			sqlSession = factory.openSession();
			tl.set(sqlSession);
		}
		return sqlSession;
	}
	public static void close(SqlSession sqlSession){
		if(sqlSession != null){
			sqlSession.close();
			tl.remove();//“Ï≥£œ÷œÛexecutor was closed
		}
	}
}
