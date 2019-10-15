package com.baizhi.kafkaab.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerDemo {

    @KafkaListener(topics = "t5")
    public void receive(ConsumerRecord<String, String> record) {
        System.out.println(record.key() + "\t" + record.value());
    }
}

