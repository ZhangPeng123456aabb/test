package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.OrderItem;
import com.baizhi.service.OrderItemService;
import com.baizhi.util.MyBatisUtils;

public class OrderItemServiceImpl implements OrderItemService  {
	SqlSession sqlSession = null;
	OrderItemDao dao = null;
	@Override
	public void insertOrderItem(OrderItem ori) {
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(OrderItemDao.class);
			dao.insertOrderItem(ori);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		
	}
}
