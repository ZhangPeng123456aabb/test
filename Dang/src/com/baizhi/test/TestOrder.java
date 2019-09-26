package com.baizhi.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.OrderDao;
import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.util.MyBatisUtils;

public class TestOrder {
	SqlSession sqlSession =null;
	OrderDao dao = null;
	@Test
	public void TestInsertOrder(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(OrderDao.class);
		Order o = new Order();
		Date d = new Date();
		o.setOrderTime(d);
		o.setTotalPrice(100.0);
		o.setUserId(8);
		o.setAddressId(13);
		dao.InsertOrder(o);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void TestSelectOrder(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(OrderDao.class);
		List<Order> or = new ArrayList();
		or = dao.SelectOrders(1);
		for(Order o:or){
			System.out.println(o);
		}
		sqlSession.close();
	}
	@Test
	public void  TestshowOrderItem(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(OrderDao.class);
		List<Order> or = new ArrayList();
		List<OrderItem> oi = new ArrayList();
		or = dao.showOrderItem(1);
		for(Order o1:or){
			System.out.println(o1);
		}
		sqlSession.close();
	}
	@Test
	public void TestUpdateOrderState(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(OrderDao.class);
		dao.updateOrderState("xuc325620190720212051012",0);
		sqlSession.commit();
		sqlSession.close();
	}
}

