package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * zyh
 */
@Configuration
@EnableWebMvc
public class ZyhWebMvcConfig implements WebMvcConfigurer {

    /**
     * 请求试图映射
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/myindex").setViewName("myindex.html");
    }

}
