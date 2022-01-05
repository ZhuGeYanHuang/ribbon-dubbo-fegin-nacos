package com.zyh.member.myloadbanace;


import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Configuration
public class MyLoadBalanceAutoConfigration {

    @Mybalance
    @Autowired(required = false)
    private List<RestTemplate> restTemplates = Collections.emptyList();


    @Bean
    public CustomizeLoadBalancerInterceptor customizeLoadBalancerInterceptor(LoadBalancerClient loadBalancerClient) {
        return new CustomizeLoadBalancerInterceptor(loadBalancerClient);
    }


    @Bean
    public SmartInitializingSingleton customizeLoadBalancerInterceptorInitializing(CustomizeLoadBalancerInterceptor customizeLoadBalancerInterceptor) {
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate restemplate :
                        MyLoadBalanceAutoConfigration.this.restTemplates) {
                    List<ClientHttpRequestInterceptor> requestInterceptors = new ArrayList<>(restemplate.getInterceptors());
                    requestInterceptors.add(customizeLoadBalancerInterceptor);
                    restemplate.setInterceptors(requestInterceptors);
                }
            }
        };
    }
}
