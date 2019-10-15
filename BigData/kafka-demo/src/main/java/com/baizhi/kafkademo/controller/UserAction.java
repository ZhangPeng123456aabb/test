package com.baizhi.kafkademo.controller;
import com.baizhi.kafkademo.entity.User;
import com.baizhi.kafkademo.kafka.ProducerDemo;
import com.baizhi.kafkademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAction {
    @Autowired
    private UserService userService;
    @Autowired
    private ProducerDemo producerDemo;
    @RequestMapping("/add")
    public String add(User user){
        if(userService.Add(user)==true){
            /*Producer.pro(user);*/
            producerDemo.send(user);
            return "redirect:/index.html";
        }else{
            return "redirect:/register.html";
        }
    }
}
