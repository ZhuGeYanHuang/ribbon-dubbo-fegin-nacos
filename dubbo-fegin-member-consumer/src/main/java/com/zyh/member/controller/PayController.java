package com.zyh.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyh.member.api.PayApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PayController {


    @Autowired
    private PayApi payApi;


    @RequestMapping(value = "pay/{money}")
    private JSONObject getOrderList(@PathVariable("money") int money) {
        JSONObject object = restTemplate.getForObject("http://super-market-pay/pay/payByCash/" + money,
                JSONObject.class);
        log.info("----object--{}", object);
        return object;
    }


    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "payCash/money/{money}")
    public JSONObject pay(@PathVariable("money") int moeny) {
        log.info("---money---{}", moeny);
        JSONObject r = payApi.payByCash();
        return r;
    }


}
