package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.OrderDao;
import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.service.OrderService;
import com.baizhi.util.MyBatisUtils;

public class OrderServiceImpl implements OrderService {
	SqlSession sqlSession = null;
	OrderDao dao = null;
	@Override
	public void InsertOrder(Order order) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(OrderDao.class);
			dao.InsertOrder(order);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}

	}

	@Override
	public List<Order> SelectOrders(Integer UserId) {
		List<Order> orderlist = new ArrayList();
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(OrderDao.class);
			orderlist = dao.SelectOrders(UserId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return orderlist;
	}
	@Override
	public List<Order> showOrderItem(Integer UserId) {
		List<Order> or = new ArrayList();
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(OrderDao.class);
			or = dao.showOrderItem(UserId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return or;
	}

	@Override
	public void updateOrderState(String OrderId, Integer state) {
		try{
			sqlSession=MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(OrderDao.class);
			dao.updateOrderState(OrderId, state);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
	}
}
