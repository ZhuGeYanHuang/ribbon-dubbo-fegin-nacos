package com.zyh.spring.resttemplatesentinel.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.zyh.spring.resttemplatesentinel.util.ExceptionUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>http调用配置</p>
 *
 * @author : zyh
 **/
@Configuration
public class RestTemplateConfig {


    @Bean
    @SentinelRestTemplate(blockHandlerClass = ExceptionUtil.class,
            blockHandler = "blockHandle",
            fallbackClass = ExceptionUtil.class,
            fallback = "fallback")
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
