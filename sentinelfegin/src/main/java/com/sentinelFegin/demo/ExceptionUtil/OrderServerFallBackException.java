package com.sentinelFegin.demo.ExceptionUtil;

import com.alibaba.fastjson.JSONObject;
import com.sentinelFegin.demo.server.OrderServer;

/**
 * <p>订单异常处理类</p>
 *
 * @author : zyh
 **/
public class OrderServerFallBackException implements OrderServer {
    @Override
    public JSONObject getList() {
        JSONObject result = new JSONObject();
        result.put("msg","降级处理");
        return result;
    }
}
