package com.zyh.order.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "order")
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "getList/byMemberId/{memberId}")
    public JSONObject getList(@PathVariable("memberId") String memberId) {
        List<String> stringList = new ArrayList<>();
        log.info("server-port---",port);
        stringList.add("o1");
        stringList.add("o2");
        stringList.add("o3");
        stringList.add("o4");
        JSONObject object = new JSONObject();
        object.put(memberId, stringList);
        return object;
    }
}
