package com.zyh.provider.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyh.api.PayApi;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class PayImplement implements PayApi {
    @Override
    public JSONObject payMoneyByCash(int money) {
        JSONObject result = new JSONObject();
        result.put("m1", "m4");
        result.put("m2", "m3");
        result.put("m3", "m2");
        result.put("m4", "m1");
        return result;
    }
}
