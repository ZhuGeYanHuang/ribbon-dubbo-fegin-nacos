package com.zyh.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyh.member.api.PayApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PayController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PayApi payApi;
//
//    @Resource
//    private PayCopyApi payCopyApi;

    @RequestMapping(value = "pay/{money}")
    private JSONObject getOrderList(@PathVariable("money") int money) {
        JSONObject object = restTemplate.getForObject("http://super-market-pay/pay/cash-Pay/" + money,
                JSONObject.class);
        log.info("----object--{}", object);
        return object;
    }


    @RequestMapping(value = "payCash/money/{money}")
    public JSONObject pay(@PathVariable("money") int money) {
        return payApi.payByCash(money);
    }


//    @RequestMapping(value = "copy/payCash/money/{money}")
//    public JSONObject payCopyApi(@PathVariable("money") int money) {
//        return payCopyApi.payByCash(money);
//    }

}
