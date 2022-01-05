package com.zyh.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemberOpenFeginDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberOpenFeginDubboApplication.class, args);
    }

}
