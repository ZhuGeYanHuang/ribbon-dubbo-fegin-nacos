package com.zyh.member.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Random;

public class MyIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        int randomInt = new Random().nextInt();
        template.header("Authorization", randomInt + "", "zyh");
    }
}
