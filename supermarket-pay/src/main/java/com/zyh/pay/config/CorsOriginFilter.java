package com.zyh.pay.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>跨域处理</p>
 *
 * @author : zyh
 **/
//@Component
public class CorsOriginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;

        //解除跨域
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Origin, X-Requested-With,Content-Type, Content-Disposition, Accept, lp, timestamp, v, hp, sign, token, platform, enAccount");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, resp);
    }

    @Override
    public void destroy() {
    }
}
