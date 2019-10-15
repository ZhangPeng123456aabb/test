package com.baizhi.kafka.testObject;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        //1. 指定kafka消费者的配置信息
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        // 反序列化器 byte[] ---> Object
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ObjectCodec.class);
        // 注意：此配置项 修改偏移量消费策略的默认行为
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // 关闭消费位置offset的自动提交功能
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        //properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,5000);
        // 消费组必须得指定
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");


        //2. 创建kafka消费者对象
        KafkaConsumer<String, User> consumer = new KafkaConsumer<String, User>(properties);
        //3. 订阅主体topic
        consumer.subscribe(Arrays.asList("t2"));
        //4. 拉取新产生的记录
        while (true) {
            ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(10));
            for (ConsumerRecord<String, User> record : records) {
                User user = record.value();
                System.out.println(user);
            }
            // 手动提交消费位置
            consumer.commitSync();
            }
        }
    }
