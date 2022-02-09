package com.sentineldubboprovider.sentineldubboprovider.mock;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.sentineldubbo.Server.OrderServer;

/**
 * <p>降级</p>
 *
 * @author : zyh
 **/
public class OrderMock implements OrderServer {
    @Override
    public JSONObject getList() {
        JSONObject m = new JSONObject();
        m.put("msg","被降级了");
        return m;
    }
}
