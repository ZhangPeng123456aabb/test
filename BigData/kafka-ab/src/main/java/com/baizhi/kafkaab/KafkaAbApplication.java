package com.baizhi.kafkaab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaAbApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAbApplication.class, args);
    }

}
