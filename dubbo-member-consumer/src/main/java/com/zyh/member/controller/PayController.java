package com.zyh.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyh.api.PayApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PayController {


    @DubboReference(mock = "com.zyh.member.mock.PayMock")
    private PayApi payApi;


    @RequestMapping(value = "payCash/money/{money}")
    public JSONObject pay(@PathVariable("money") int money) {
        return payApi.payMoneyByCash(money);
    }


}
