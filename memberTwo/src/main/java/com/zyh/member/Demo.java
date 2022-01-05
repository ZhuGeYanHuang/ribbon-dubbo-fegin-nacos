package com.zyh.member;

import com.zyh.member.api.PayService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class Demo {
    public static void main(String[] args) {
        PayService service = Feign.builder() .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(1000, 3500))
            .retryer(new Retryer.Default(5000, 5000, 3))
            .target(PayService.class, "http://localhost:8089/");
        System.out.println(service.payByCash("111"));
    }
}
