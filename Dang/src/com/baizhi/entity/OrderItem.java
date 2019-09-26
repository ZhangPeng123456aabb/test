package com.baizhi.entity;

public class OrderItem {
	private Integer ItemId;
	private Double DangPrice;
	private Integer Count;
	private Integer BookId;
	private String OrderId1;
	private Book book;
	private Order order;
	public OrderItem(Integer itemId, Double dangPrice, Integer count,
			Integer bookId, String orderId1, Book book, Order order) {
		super();
		ItemId = itemId;
		DangPrice = dangPrice;
		Count = count;
		BookId = bookId;
		OrderId1 = orderId1;
		this.book = book;
		this.order = order;
	}
	public OrderItem() {
		super();
	}
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public Double getDangPrice() {
		return DangPrice;
	}
	public void setDangPrice(Double dangPrice) {
		DangPrice = dangPrice;
	}
	public Integer getCount() {
		return Count;
	}
	public void setCount(Integer count) {
		Count = count;
	}
	public Integer getBookId() {
		return BookId;
	}
	public void setBookId(Integer bookId) {
		BookId = bookId;
	}
	public String getOrderId1() {
		return OrderId1;
	}
	public void setOrderId1(String orderId1) {
		OrderId1 = orderId1;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [ItemId=" + ItemId + ", DangPrice=" + DangPrice
				+ ", Count=" + Count + ", BookId=" + BookId + ", OrderId1="
				+ OrderId1 + ", book=" + book + ", order=" + order + "]";
	}
	
	
}
