package com.zyh.member.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;


    @RequestMapping(value = "getOrderList/memberId/{memberId}")
    private JSONObject getOrderList(@PathVariable("memberId") String memberId) {
        JSONObject object = restTemplate.getForObject("http://super-market-order/order/getList/byMemberId/" + memberId,
                JSONObject.class);
        log.info("----object--{}", object);


        //自定义轮询算法负载均衡器
//        JSONObject object2 = restTemplate.getForObject(getUrl("super-market-order") + "/order/getList/byMemberId/" + memberId,
//                JSONObject.class);
//        log.info("----object--2--{}", object2);

        return object;
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    AtomicInteger integer = new AtomicInteger(0);

    public String getUrl(String serverName) {
        //获取服务列表
        List<ServiceInstance> listInstan = discoveryClient.getInstances(serverName);

        //获取服务个数
        int models = listInstan.size();


        //轮询使用  叠加
        int myNeed = 0;
        for (; ; ) {
            int oldValue = integer.get();
            int mycount = (oldValue & (models - 1));

            if (integer.compareAndSet(oldValue, oldValue + 1)) {
                myNeed = mycount;
                break;
            }
        }
        ServiceInstance instance = listInstan.get(myNeed);
        log.info("--getUrl---" + instance.getUri().toString());
        return instance.getUri().toString();
    }
}
