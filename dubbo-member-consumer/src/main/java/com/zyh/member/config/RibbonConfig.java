package com.zyh.member.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RibbonConfig {

//    @Bean
    public IRule irule() {
        return new NacosRule();
    }

}
