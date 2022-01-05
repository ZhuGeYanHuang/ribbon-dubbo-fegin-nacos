package com.zyh.ribbondemo.demo;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import rx.Observable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RibbonTest {
    public static void main(String[] args) {

        //服务列表
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("127.0.0.1",9097));
        serverList.add(new Server("127.0.0.1",9098));


        //构建负载均衡器
        ILoadBalancer iLoadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);

        //使用客户端负载均衡
        for (int i = 0; i < 10; i++) {
           String reuslt = LoadBalancerCommand.<String>builder().withLoadBalancer(iLoadBalancer).build().submit(new ServerOperation<String>() {
                  @Override
                  public Observable<String> call(Server server) {
                      //生成链接
                      String urlAddrStr = "http://"+server.getHostPort()+"/order/getList/byMemberId/me1";
                      System.out.println("---urlAddrStr--"+urlAddrStr);
                      //
                      try {
                          URL url = new URL(urlAddrStr);
                          URLConnection connection=url.openConnection();
                          connection.connect();
                          InputStream stream=connection.getInputStream();
                          byte[] b = new byte[stream.available()];
                          stream.read(b);
                          return Observable.just(new String(b));
                      } catch (MalformedURLException e) {
                          e.printStackTrace();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                      return null;
               }
             }
           ).toBlocking().first();
            System.out.println("---reuslt---"+reuslt);
        }

    }
}
