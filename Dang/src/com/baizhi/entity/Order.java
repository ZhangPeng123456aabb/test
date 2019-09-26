package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class Order {
	private String OrderId1;
	private Date OrderTime;;
	private Double TotalPrice;
	private Integer state;
	private Integer UserId;
	private Integer AddressId;
	private Address address;
	private User user;
	private List<OrderItem> itemList;
	public Order(String orderId1, Date orderTime, Double totalPrice,
			Integer state, Integer userId, Integer addressId, Address address,
			User user, List<OrderItem> itemList) {
		super();
		OrderId1 = orderId1;
		OrderTime = orderTime;
		TotalPrice = totalPrice;
		this.state = state;
		UserId = userId;
		AddressId = addressId;
		this.address = address;
		this.user = user;
		this.itemList = itemList;
	}
	public Order() {
		super();
	}
	public String getOrderId1() {
		return OrderId1;
	}
	public void setOrderId1(String orderId1) {
		OrderId1 = orderId1;
	}
	public Date getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getAddressId() {
		return AddressId;
	}
	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Order [OrderId1=" + OrderId1 + ", OrderTime=" + OrderTime
				+ ", TotalPrice=" + TotalPrice + ", state=" + state
				+ ", UserId=" + UserId + ", AddressId=" + AddressId
				+ ", address=" + address + ", user=" + user + ", itemList="
				+ itemList + "]";
	}
	
	
	
	
}
