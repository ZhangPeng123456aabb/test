package com.baizhi.kafkaab.transaction;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.*;

public class ConsumerTransProducerDemo {
    public static void main(String[] args) {
        //1. 初始化生产者和消费者的配置对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(consumerConfig());
        KafkaProducer<String, String> producer = new KafkaProducer<>(producerConfig());
        //2. 消费者订阅topic
        consumer.subscribe(Arrays.asList("t5"));
        //3. 事务操作
        producer.initTransactions();
        while (true) {
            producer.beginTransaction();
            try {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                for (ConsumerRecord<String, String> record : records) {
                    // 需要业务处理的内容
                    System.out.println(record.key() + "--->" + record.value());
                    producer.send(new ProducerRecord<String,String>("t6","t6:"+record.value()));
                    // 模拟错误
                    // int m = 1/0;
                    // 将消费位置记录到map集合中
                    offsets.put(new TopicPartition("t5",record.partition()),new OffsetAndMetadata(record.offset()+1));
                }
                // 维护消费位置  将事务内的消费位置信息 提交到kafka中
                producer.sendOffsetsToTransaction(offsets,"group1");
                // 正确操作 提交事务
                producer.commitTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                producer.abortTransaction();
            }
        }
    }
    public static Properties producerConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, UUID.randomUUID().toString());
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, Boolean.TRUE);
        properties.put(ProducerConfig.RETRIES_CONFIG, 5);
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 3000);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 2000);
        return properties;
    }
    public static Properties consumerConfig() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        properties.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
        return properties;
    }
}
