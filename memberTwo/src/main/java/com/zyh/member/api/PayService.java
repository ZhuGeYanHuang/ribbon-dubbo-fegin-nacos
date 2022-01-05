package com.zyh.member.api;

import com.alibaba.fastjson.JSONObject;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PayService {


    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("GET /pay/payByCash/{money}")
    public JSONObject payByCash(@Param("money") String money);

}
