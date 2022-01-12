package com.zyh.spring.resttemplatesentinel.util;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * <p>异常处理类</p>
 *
 * @author : zyh
 **/
public class ExceptionUtil {


    /**
     * 处理限流的方法  必须是 静态类，且 比 被调用方的参数多一个 blockException  例如
     * 原传参为  method(int param1,int param2) -> blockHandle(int param1,int param2,BlockException exception)
     *
     * @param exception
     * @return
     */
    public static SentinelClientHttpResponse blockHandle(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        JSONObject object = new JSONObject();
        object.put("msg", "被限流了");

        return new SentinelClientHttpResponse(object.toJSONString());

    }

    /**
     * 处理降级的方法  必须是 静态类
     * 参数和上面的类似
     *
     * @param exception
     * @return
     */
    public static SentinelClientHttpResponse fallback(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        JSONObject object = new JSONObject();
        object.put("msg", "被降级了");

        return new SentinelClientHttpResponse(object.toJSONString());

    }


}
