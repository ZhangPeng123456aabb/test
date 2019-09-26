package com.baizhi.entity;

public class Address {
	private Integer id;
	private String receive_name;
	private String address;
	private String telphone;
	private Integer UserId;
	private int status;  
	private int state;
	public Address(Integer id, String receive_name, String address,
			String telphone, Integer userId, int status, int state) {
		super();
		this.id = id;
		this.receive_name = receive_name;
		this.address = address;
		this.telphone = telphone;
		UserId = userId;
		this.status = status;
		this.state = state;
	}
	public Address() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", receive_name=" + receive_name
				+ ", address=" + address + ", telphone=" + telphone
				+ ", UserId=" + UserId + ", status=" + status + ", state="
				+ state + "]";
	} 
	
}
