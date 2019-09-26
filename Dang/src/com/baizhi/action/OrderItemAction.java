package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.entity.User;
import com.baizhi.service.OrderItemService;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.OrderItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;

public class OrderItemAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	OrderItemService ois = new OrderItemServiceImpl();
	OrderService or = new OrderServiceImpl();
	private List<OrderItem> o;
	private List<Order> o1;
	public List<Order> getO1() {
		return o1;
	}
	public void setO1(List<Order> o1) {
		this.o1 = o1;
	}
	private OrderItem oi;
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public OrderItem getOi() {
		return oi;
	}
	public void setOi(OrderItem oi) {
		this.oi = oi;
	}
	public List<OrderItem> getO() {
		return o;
	}
	public void setO(List<OrderItem> o) {
		this.o = o;
	}
	public String showOrderItem(){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int i =0;
		System.out.println(user);
		i = user.getId();
		o1 = or.showOrderItem(i);
		System.out.println(o1);
		return "showSuccess";
	}
	
}
