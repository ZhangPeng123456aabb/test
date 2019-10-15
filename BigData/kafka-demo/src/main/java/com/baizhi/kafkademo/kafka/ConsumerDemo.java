package com.baizhi.kafkademo.kafka;

import com.baizhi.kafkademo.util.MailUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDemo {
    @KafkaListener(topics = "t1")
    public void receive(ConsumerRecord<String,String> record){
        MailUtil.sendSimpleMail(record.value());
        System.out.println(record.key()+"\t"+record.value());
    }
}
