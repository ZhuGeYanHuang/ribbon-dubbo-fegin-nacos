package com.zyh.pay.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>订单服务</p>
 *
 * @author : zyh
 **/
@RestController
@RequestMapping("order")
public class OrderController {


    @GetMapping("/getOrderList")
    public JSONObject getOrderList() {
        JSONObject list = new JSONObject();

        list.put("m1", "m3");
        list.put("m2", "m2");
        list.put("m3", "m1");


        return list;
    }


}
