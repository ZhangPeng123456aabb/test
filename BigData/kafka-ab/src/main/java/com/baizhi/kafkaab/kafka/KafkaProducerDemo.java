package com.baizhi.kafkaab.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class KafkaProducerDemo {

    @Autowired
    private KafkaTemplate<String,String> template;

    // 计划任务，定时发送数据
    // cron 秒 分 时 日 月 周 年(省略)
    @Scheduled(cron = "0/10 * * * * ?")
    public void send(){
        template.send("t5", UUID.randomUUID().toString(),"Hello Kafka");
        //System.out.println(new Date());
    }
}
