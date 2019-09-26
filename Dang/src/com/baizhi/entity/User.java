package com.baizhi.entity;

public class User {
	private Integer id;
	private String email;
	private String nickname;
	private String password;
	private int state;
	public User(Integer id, String email, String nickname, String password,
			int state) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.state = state;
	}
	public User() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + ", state=" + state + "]";
	}
	
	
}
