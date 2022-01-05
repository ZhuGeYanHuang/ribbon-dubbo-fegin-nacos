package com.zyh.member.api;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "super-market-pay", path = "pay")
public interface PayApi {

    @RequestMapping(value = "payByCash/{money}")
    JSONObject payByCash(@PathVariable("money") int param);

}
