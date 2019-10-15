package com.baizhi.kafkademo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

public class kafkaProducerDemo {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    // 计划任务，定时发送数据
    // cron 秒 分 时 日 月 周 年(省略)
    @Scheduled(cron = "1/10 * * * * ?")
    public void send(){
        /*kafkaTemplate.send("t1", UUID.randomUUID().toString(),"Hello kafka");*/
        System.out.println(new Date());
    }
}
