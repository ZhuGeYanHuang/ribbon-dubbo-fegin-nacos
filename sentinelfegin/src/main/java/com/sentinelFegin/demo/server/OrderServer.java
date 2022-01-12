package com.sentinelFegin.demo.server;

import com.alibaba.fastjson.JSONObject;
import com.sentinelFegin.demo.ExceptionUtil.OrderServerFallBackException;
import com.sentinelFegin.demo.config.FeginConfigration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>订单服务</p>
 *
 * @author : zyh
 **/
@FeignClient(value = "super-market-pay",path = "order",fallback = OrderServerFallBackException.class,configuration = FeginConfigration.class)
public interface OrderServer {

    @RequestMapping("/getOrderList")
    JSONObject getList();

}
