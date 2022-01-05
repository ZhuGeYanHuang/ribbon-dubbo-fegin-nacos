package com.zyh.pay.controller;


import com.alibaba.fastjson.JSONObject;
import com.zyh.pay.impl.PayImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pay")
@Slf4j
public class PayMoneyController {

    @Autowired
    private PayImplement payImplement;

    @RequestMapping(value = "/payByCash/{money}")
    public JSONObject pay(@PathVariable int money) {
        log.info("money--{}--", money);
        return payImplement.payByCash(money);
    }


}
