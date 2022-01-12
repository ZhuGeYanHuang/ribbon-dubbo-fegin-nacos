package com.sentinelFegin.demo.config;

import com.sentinelFegin.demo.ExceptionUtil.OrderServerFallBackException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>fegin配置类</p>
 *
 * @author : zyh
 **/
public class FeginConfigration {

    @Bean
    public OrderServerFallBackException orderServerFallBackException(){
        return new OrderServerFallBackException();
    }

}
