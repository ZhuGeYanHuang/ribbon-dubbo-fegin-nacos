package com.zyh.member.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.*;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author: LiGuo
 * @since: 2018-07-16 10:05:45
 * @note:
 */
public class OkHttpUtil {

    private OkHttpUtil() {
    }


    private static OkHttpClient okHttpClient;

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .readTimeout(10, TimeUnit.MINUTES)
                    .writeTimeout(10, TimeUnit.MINUTES)
                    .build();

        }
        return okHttpClient;

    }

    /**
     * 普通post请求
     *
     * @param url        地址
     * @param headersMap 请求头参数
     * @return
     * @throws Exception
     */
    public static Optional<JSONObject> post(String url, Map<String, String> headersMap, Object object) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        //添加体
        String bodyStr = JSON.toJSONString(object, SerializerFeature.PrettyFormat);
        RequestBody requestBody = RequestBody.create(mediaType, bodyStr);
        return postCore(url, headersMap, requestBody);
    }

    /**
     * 文件post请求
     *
     * @param url  地址
     * @param file 文件
     * @return
     * @throws Exception
     */
    public static Optional<JSONObject> post(String url, Map<String, String> headersMap, File file) throws Exception {
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .setType(MultipartBody.FORM)
                .build();
        return postCore(url, headersMap, requestBody);

    }


    /**
     * 文件post请求
     *
     * @param url   地址
     * @param bytes 二进制数组
     * @return
     * @throws Exception
     */
    public static Optional<JSONObject> post(String url, Map<String, String> headersMap, byte[] bytes) throws Exception {
        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody fileBody = RequestBody.create(mediaType, bytes, 0, bytes.length);
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("file", "", fileBody)
                .setType(MultipartBody.FORM)
                .build();
        return postCore(url, headersMap, requestBody);

    }

    /**
     * post请求核心
     *
     * @param url         地址
     * @param headersMap  请求头字典
     * @param requestBody 请求body
     * @return
     * @throws Exception
     */
    private static Optional<JSONObject> postCore(String url, Map<String, String> headersMap, RequestBody requestBody) throws Exception {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        StringBuilder postContent = new StringBuilder("POST ").append(url).append(" HTTP/1.1\n");
        headersMap.forEach((k, v) -> {
            builder.addHeader(k, v);
            postContent.append(k).append(": ").append(v).append("\n");
        });
        postContent.append("\n").append("file:二进制").append("\n");
        Request request = builder.build();
        Response response;
        response = getOkHttpClient().newCall(request).execute();
        String resultStr = response.body().string();
        JSONObject json = JSON.parseObject(resultStr);
        postContent.append("\n").append(response.protocol().toString()).append(" ")
                .append(response.code()).append(response.message()).append("\n");
        postContent.append("\n").append(JSON.toJSONString(json, SerializerFeature.PrettyFormat));
        System.out.println(postContent.toString());
        return Optional.ofNullable(json);

    }

    private static Optional<JSONObject> postCore1(String url, Map<String, String> headersMap, File file) throws Exception {
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        headersMap.forEach((k, v) -> {
            builder.addHeader(k, v);
        });
        Request request = builder.build();
        Response response;
        response = getOkHttpClient().newCall(request).execute();
        String resultStr = response.body().string();
        JSONObject json = JSON.parseObject(resultStr);
        return Optional.ofNullable(json);

    }


    /**
     * get请求
     *
     * @param url 地址
     * @return
     * @throws Exception
     */
    public static Optional<JSONObject> get(String url) throws Exception {
        Request.Builder builder = new Request.Builder()
                .url(url).get();
        Request request = builder.build();
        Response response;
        response = getOkHttpClient().newCall(request).execute();
        String result = response.body().string();
        return Optional.ofNullable(JSON.parseObject(result));
    }

}
