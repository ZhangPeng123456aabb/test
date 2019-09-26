package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
     public User selectOne(User u);
     public void insert(User u);
     void updateState(User u);
}
