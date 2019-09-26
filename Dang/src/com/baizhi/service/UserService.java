package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
	 public User login(User u);
     public void register(User u);
     void updateState(User u);
}
