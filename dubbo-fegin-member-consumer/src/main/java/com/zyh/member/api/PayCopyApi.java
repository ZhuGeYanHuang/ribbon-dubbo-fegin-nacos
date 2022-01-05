package com.zyh.member.api;


import com.alibaba.fastjson.JSONObject;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(value = "super-market-pay", path = "pay")
//public interface PayCopyApi {
//
//    @RequestLine("GET /payByCash/{money}")
//    JSONObject payByCash(@Param("money") int param);
//
//}
