package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.util.MyBatisUtils;

public class TestOrderItem {
	SqlSession sqlSession = null;
	OrderItemDao dao = null;
	
	@Test
	public void TestOrderItem(){
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(OrderItemDao.class);
		OrderItem ori = new OrderItem();
		ori.setDangPrice(66.66);
		ori.setBookId(13);
		ori.setCount(100);
		/*ori.setOrderId("xuc325620190720212051012");*/
		dao.insertOrderItem(ori);
		sqlSession.commit();
		sqlSession.close();
	}
}
