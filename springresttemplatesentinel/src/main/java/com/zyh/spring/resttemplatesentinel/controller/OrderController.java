package com.zyh.spring.resttemplatesentinel.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>订单调用</p>
 *
 * @author : zyh
 **/
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getList")
    public JSONObject getList(){
        JSONObject result=restTemplate.getForObject("http://super-market-pay/order/getOrderList",JSONObject.class);
        return result;
    }

}
