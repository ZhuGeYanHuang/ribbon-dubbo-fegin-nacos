package com.zyh.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class MemberdubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberdubboApplication.class, args);
    }

}
