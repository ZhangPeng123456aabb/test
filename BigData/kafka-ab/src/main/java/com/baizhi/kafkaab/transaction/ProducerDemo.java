package com.baizhi.kafkaab.transaction;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public class ProducerDemo {
    public static void main(String[] args) {
        //准备kafka配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, UUID.randomUUID().toString());
        //开启幂等性支持
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,5);
        properties.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,3000);
        //创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        producer.initTransactions();

        try {
            for(int i=10;i<20;i++){
                if(i==56) {
                    int m = 1 / 0;//人为制造错误
                }
                ProducerRecord<String, String> record = new ProducerRecord<>("t2", UUID.randomUUID().toString(), "Hello kafka" + i);
                producer.send(record);
            }
            //提交事务
            producer.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            producer.abortTransaction();
        }finally {
            producer.flush();
            producer.close();
        }

    }
}
