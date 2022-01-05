//package com.zyh.member.test;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest()
//public class TempPassTest {
//
//
//    @Test
//    public void auditPassTest() {
//        //参数
//        JSONObject passParam = new JSONObject();
//        //
////        passParam.put("param", "${jndi:rmi:http://localhost:9090/getOrderList}");
//        Map<String, String> headersMap = new HashMap();
////        headersMap.put("x-auth-channel", "admin");
////        headersMap.put("x-auth-token", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODM2MzUiLCJpYXQiOjE2MTIzMzcxNTAsInN1YiI6IntcImFybUVudGVycHJpc2VJZFwiOlwiMTUxODRcIixcImNoYW5uZWxcIjpcImFkbWluXCIsXCJlbnRlcnByaXNlVHlwZVwiOjMsXCJzdGFyQWNjb3VudFwiOlwiODgzNjM1XCIsXCJzdGFyQWNjb3VudE5hbWVcIjpcIui2hee6p-euoeeQhuWRmFwifSIsImlzcyI6ImFkbWluIn0.RLINsDwpn_hIp1gr0eNg_kI6vjdoZCMaAqYx96D89-I");
////        headersMap.put("Content-Type", "application/json");
////        headersMap.put("yame-source", "open-star-admin");
////        headersMap.put("cookie", "LSESSIONID=43484bb5-08c5-4f84-94ca-5401dd3db662; TSESSIONID=083fe195-3eb9-4883-b8ae-50301cf5cec0");
////        headersMap.put("timestamp", String.valueOf(Timestamp.valueOf(LocalDateTime.now()).getTime()));
//
//        try {
//            //生产环境
//            Optional<JSONObject> result =
//                    OkHttpUtil.post("http://localhost:9090/getOrderList1",
//                            headersMap, passParam);
//        } catch (Exception e) {
//            System.out.println();
//            e.printStackTrace();
//        }
//    }
//
//
//}
