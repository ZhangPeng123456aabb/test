package com.baizhi.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        //1.指定kafka消费者的配置信息
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        //反序列化器 byte[]---->Object
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        //指定消费组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"group1");
        //创建kafka消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //订阅主题
        consumer.subscribe(Arrays.asList("t1"));
        //拉取新产生的数据
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(100));
            for(ConsumerRecord<String,String> record:records){
                System.out.println(record.key()+"\t"+record.value()+"\t"+record.topic()+"\t"+record.offset()+"\t"+record.timestamp()+"\t"+record.partition());
            }
        }
    }
}
