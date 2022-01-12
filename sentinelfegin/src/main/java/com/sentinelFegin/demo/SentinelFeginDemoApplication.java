package com.sentinelFegin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelFeginDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeginDemoApplication.class, args);
    }

}
