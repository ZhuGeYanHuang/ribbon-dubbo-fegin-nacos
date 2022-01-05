package com.zyh.member.myloadbanace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URI;

@Slf4j
public class CustomizeLoadBalancerInterceptor implements ClientHttpRequestInterceptor {

    private LoadBalancerClient loadBalancerClient;

    private LoadBalancerRequestFactory loadBalancerRequestFactory;


    public CustomizeLoadBalancerInterceptor(LoadBalancerClient loadBalancerClient, LoadBalancerRequestFactory loadBalancerRequestFactory) {
        this.loadBalancerClient = loadBalancerClient;
        this.loadBalancerRequestFactory = loadBalancerRequestFactory;
    }

    public CustomizeLoadBalancerInterceptor(LoadBalancerClient loadBalancerClient) {
        this(loadBalancerClient, new LoadBalancerRequestFactory(loadBalancerClient));
    }


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        URI uri = request.getURI();
        String serverName = uri.getHost();
        log.info("--当前自定义拦截器--拦截的是--{}", serverName);
        Assert.isTrue(serverName != null, "请求的uri不可用->" + uri);
        return loadBalancerClient.execute(serverName, loadBalancerRequestFactory.createRequest(request, body, execution));
    }
}
