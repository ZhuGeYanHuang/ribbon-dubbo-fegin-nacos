package com.zyh.pay.api;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "super-market-pay",path ="pay" )
public interface PayApi {

    @RequestMapping(value = "payByCash")
    JSONObject payByCash(@RequestBody int money);

}
