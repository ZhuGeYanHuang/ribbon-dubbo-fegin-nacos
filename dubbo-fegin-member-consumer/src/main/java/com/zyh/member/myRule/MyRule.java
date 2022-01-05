package com.zyh.member.myRule;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.ExtendBalancer;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class MyRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Autowired
    private NacosServiceManager nacosServiceManager;

    @Override
    public Server choose(Object key) {
        try {
            Map<String,String> metadata = this.nacosDiscoveryProperties.getMetadata();

            DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) getLoadBalancer();
            String name = loadBalancer.getName();

            NamingService namingService = nacosServiceManager
                    .getNamingService(nacosDiscoveryProperties.getNacosProperties());
            List<Instance> instances = namingService.selectInstances(name,true);
            if (CollectionUtils.isEmpty(instances)) {
                log.warn("no instance in service {}", name);
                return null;
            }

            List<Instance> instancesToChoose = instances;
            //优先根据版本进行匹配
            if (StringUtils.isNotBlank(metadata.get("version"))) {
                List<Instance> sameClusterInstances = instances.stream()
                        .filter(instance -> Objects.equals(metadata.get("version"),
                                instance.getMetadata().get("version")))
                        .collect(Collectors.toList());
                //没有版本的就报错
                Assert.isTrue(sameClusterInstances!=null&&sameClusterInstances.size()>0,"没有对应版本的服务，请检查服务是否正常！");
                //没有报错就返回对应的实例
                instancesToChoose = sameClusterInstances;
            }

            Instance instance = ExtendBalancer.getHostByRandomWeight2(instancesToChoose);

            return new NacosServer(instance);
        } catch (Exception e) {
            log.warn("NacosRule error", e);
            return null;
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

}
