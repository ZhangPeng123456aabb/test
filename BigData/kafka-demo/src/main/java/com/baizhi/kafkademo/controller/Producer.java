package com.baizhi.kafkademo.controller;

import com.baizhi.kafkademo.entity.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public class Producer {
    public static void pro(User user) {
        //准备kafka生产者配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        //String序列化（Object--->byte[]）器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        //创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        //生产记录并将其发布
        ProducerRecord<String, String> record = new ProducerRecord<>("t1", UUID.randomUUID().toString(),user.getEmail());
        System.out.println(user.getEmail());
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
