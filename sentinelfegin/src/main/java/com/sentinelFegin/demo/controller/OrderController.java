package com.sentinelFegin.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sentinelFegin.demo.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>订单消费端</p>
 *
 * @author : zyh
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    @RequestMapping("/getOrderList")
    public JSONObject getList(){
       return orderServer.getList();
    }

}
