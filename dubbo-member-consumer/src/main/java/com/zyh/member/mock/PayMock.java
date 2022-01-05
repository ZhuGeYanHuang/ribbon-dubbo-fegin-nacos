package com.zyh.member.mock;

import com.alibaba.fastjson.JSONObject;
import com.zyh.api.PayApi;

public class PayMock implements PayApi {

    @Override
    public JSONObject payMoneyByCash(int money) {
        // 伪造容错数据，此方法只在出现 RpcException 时被执行；
        JSONObject result = new JSONObject();
        result.put("error", "容错数据");
        return result;
    }
}