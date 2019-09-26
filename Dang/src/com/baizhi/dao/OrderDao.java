package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;

public interface OrderDao {
	void InsertOrder(Order order);
	List<Order> SelectOrders(Integer UserId);
	List<Order> showOrderItem(Integer UserId);
	void updateOrderState(@Param("OrderId1")String OrderId,@Param("state")Integer state);
}
