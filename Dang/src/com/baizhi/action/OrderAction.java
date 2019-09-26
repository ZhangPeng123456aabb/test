package com.baizhi.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.Cart;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.entity.User;
import com.baizhi.service.OrderItemService;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.OrderItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.baizhi.util.OrderNoUtil;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction {
	OrderService order =new OrderServiceImpl();
	OrderItemService or = new OrderItemServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	Map<String,Object> session = ActionContext.getContext().getSession();
	private List<Order> ord;
	private Order o1;
	private Address address;
	private Integer addressId;
	private String out_trade_no;
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Order getO() {
		return o1;
	}
	public void setO(Order o) {
		this.o1 = o;
	}
	public List<Order> getOrd() {
		return ord;
	}
	public void setOrd(List<Order> ord) {
		this.ord = ord;
	}
	public String insertOrder(){
	  List<OrderItem> itemList = new ArrayList();
		Date d = new Date();
		User u =new User();
		Order o = new Order();
		OrderItem ori = new OrderItem();
		HttpSession session1 = request.getSession();
		HttpSession session4 = request.getSession();
		User user =(User)session1.getAttribute("user");
		Cart cart = (Cart)session.get("cart");
		Map<Integer, Item> addMap = cart.getAddMap();
		/*System.out.println(user);*/
		o.setUserId(user.getId());
		o.setTotalPrice(cart.getTotalPrice());
		o.setOrderTime(d);
		o.setOrderId1(OrderNoUtil.getOrderNo());
		o.setAddressId(addressId);
		order.InsertOrder(o);
		System.out.println(o);
		Set<Entry<Integer, Item>> set = addMap.entrySet();
		Integer bookId=0;
		double DangPrice=0;
		Integer count = 0;
		  for(Map.Entry<Integer, Item> entry:set){
			  Item i=entry.getValue();
			  bookId=i.getBook().getBookId(); 
			  DangPrice=i.getBook().getDangPrice();
			  count = i.getBuyCount();
			  ori.setBookId(bookId);
				ori.setDangPrice(DangPrice);
				ori.setOrderId1(o.getOrderId1());
				ori.setCount(count);
				or.insertOrderItem(ori);
				itemList.add(ori);	
		  }
		o.setItemList(itemList);
		session4.setAttribute("o1",o.getOrderId1());
		System.out.println(o);
		return "insertOrderSuccess";
	}
	public String showOrders(){
		HttpSession session1 = request.getSession();
		User user =(User)session1.getAttribute("user");
		ord = order.SelectOrders(user.getId());
		return "showOrdersSuccess";
	}
	public String updateOrderStatus(){
		order.updateOrderState(out_trade_no,0);
		return "updateOrderStatusSuccess";
	}
}
