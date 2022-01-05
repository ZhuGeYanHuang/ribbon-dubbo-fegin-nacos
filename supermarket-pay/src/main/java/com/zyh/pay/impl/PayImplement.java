package com.zyh.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyh.pay.api.PayApi;
import org.springframework.stereotype.Service;

@Service
public class PayImplement implements PayApi {
    @Override
    public JSONObject payByCash(int money) {
        JSONObject result = new JSONObject();
        result.put("result", true);
        return result;
    }
}
