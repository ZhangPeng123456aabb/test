package com.baizhi.kafkademo.kafka;

import com.baizhi.kafkademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerDemo {
    @Autowired
    private KafkaTemplate<String,String> template;
    public void send(User user){
        template.send("t1",user.getUsername(),user.getEmail());
    }
}
