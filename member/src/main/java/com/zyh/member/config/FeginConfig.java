package com.zyh.member.config;


import com.zyh.member.intercepter.MyIntercepter;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {


    @Bean
    public Logger.Level printFeginLog() {
        return Logger.Level.FULL;
    }


    /**
     * 自定义拦截器
     *
     * @return
     */
//    @Bean
//    public MyIntercepter myIntercepter() {
//        return new MyIntercepter();
//    }


    //    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("zyh", "root");
//    }

//    @Bean
//    public Contract feginContract() {
//        return new Contract.Default();
//    }

//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5, TimeUnit.SECONDS,5,TimeUnit.SECONDS,false);
//    }


}
