package com.dubbo.sentineldubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.sentineldubbo.Server.OrderServer;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>订单服务</p>
 *
 * @author : zyh
 **/
@DubboService
public class OrderImplement implements OrderServer {
    @Override
    public JSONObject getList() {
        JSONObject list = new JSONObject();
        list.put("l1", "m1");
        list.put("l2", "m2");
        list.put("l3", "m3");
        list.put("l4", "m4");
        list.put("l5", "m5");
        return list;
    }
}
