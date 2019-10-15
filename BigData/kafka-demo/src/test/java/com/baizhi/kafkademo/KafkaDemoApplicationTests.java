package com.baizhi.kafkademo;

import com.baizhi.kafkademo.dao.UserDao;
import com.baizhi.kafkademo.entity.User;
import com.baizhi.kafkademo.util.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaDemoApplication.class)
public class KafkaDemoApplicationTests {
@Autowired
private UserDao userDao;
    @Test
    public void contextLoads() {
        /*User user = new User();
        user.setId(2);
        user.setUsername("张朋");
        user.setPassword("123456");
        user.setEmail("2281306880@qq.com");
        userDao.insert(user);*/
        MailUtil.sendSimpleMail("2281306880@qq.com");
    }

}
