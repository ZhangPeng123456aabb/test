package com.baizhi.kafkademo.dao;

import com.baizhi.kafkademo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserDao {
    @Insert("insert into user(id,username,password,email) values(#{id},#{username},#{password},#{email})")
    Boolean insert(User user);
}
