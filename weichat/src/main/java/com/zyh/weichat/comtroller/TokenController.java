package com.zyh.weichat.comtroller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TokenController {




    @RequestMapping("/weixin/config")
    public String signaConfig(HttpServletRequest request) {
        log.info("---{}--",request);
        request.getParameterMap();
        return  null;
    }

}
