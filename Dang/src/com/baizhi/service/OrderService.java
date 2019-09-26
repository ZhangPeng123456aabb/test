package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;

public interface OrderService {
	void InsertOrder(Order order);
	List<Order> SelectOrders(Integer UserId);
	List<Order> showOrderItem(Integer UserId);
	void updateOrderState(String OrderId,Integer state);
}
