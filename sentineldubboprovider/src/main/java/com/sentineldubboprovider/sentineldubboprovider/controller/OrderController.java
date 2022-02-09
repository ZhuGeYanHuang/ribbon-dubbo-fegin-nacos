package com.sentineldubboprovider.sentineldubboprovider.controller;

import com.alibaba.csp.sentinel.adapter.dubbo.config.DubboAdapterGlobalConfig;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.dubbo.sentineldubbo.Server.OrderServer;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.AsyncRpcResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * <p>订单查询</p>
 *
 * @author : zyh
 **/
@RestController
public class OrderController {


    @DubboReference(mock = "com.sentineldubboprovider.sentineldubboprovider.mock.OrderMock")
    private OrderServer orderServer;

    @RequestMapping("getOrderList")
    public JSONObject getList() {
        return orderServer.getList();
    }

}
