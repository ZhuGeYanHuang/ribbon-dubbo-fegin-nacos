package com.zyh.pay.controller;


import com.alibaba.fastjson.JSONObject;
import com.zyh.api.PayApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DubboService
@RequestMapping("pay")
public class PayMoneyController implements PayApi {

    @Override
    @RequestMapping(value = "payByCash")
    public JSONObject payMoneyByCash() {
        JSONObject result = new JSONObject();
        result.put("result", true);
        return result;
    }
}
