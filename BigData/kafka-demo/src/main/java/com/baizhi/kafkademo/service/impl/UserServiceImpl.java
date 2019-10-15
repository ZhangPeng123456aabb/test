package com.baizhi.kafkademo.service.impl;

import com.baizhi.kafkademo.dao.UserDao;
import com.baizhi.kafkademo.entity.User;
import com.baizhi.kafkademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public Boolean Add(User user) {
        if(userDao.insert(user)==true){
            return true;
        }else{
            return false;
        }
    }
}
