package com.zyh.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyh.api.PayApi;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class PayImplement implements PayApi {
    @Override
    public JSONObject payMoneyByCash() {
        JSONObject result = new JSONObject();
        result.put("result", true);
        return result;
    }
}
