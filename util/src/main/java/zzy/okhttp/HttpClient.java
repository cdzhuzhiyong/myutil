package zzy.okhttp;

import okhttp3.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ${http请求工具,JDK1.8以上版本}
 * cdzhuzhiyong
 * 2018/7/15 18:19
 **/
public class HttpClient {
    private final OkHttpClient CLIENT = new OkHttpClient();
    private HttpResponse httpResponse = new HttpResponse();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    //不带参数的get请求
    public HttpResponse get(String url){
        Request request = new Request.Builder()
                                .url(url)
                                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            httpResponse.setSuccess(true);
            String result = response.body().string();
            httpResponse.setResult(result);
        } catch (Exception e) {
            httpResponse.setSuccess(false);
            httpResponse.setError_msg("HTTP请求异常");
        }
        return httpResponse;
    }
    //带参数的get请求
    public HttpResponse get(String url, Map<String,String> params){
        String param = getParam(params);
        Request request = new Request.Builder()
                .url(url+"/"+param)
                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            httpResponse.setSuccess(true);
            String result = response.body().string();
            httpResponse.setResult(result);
        } catch (Exception e) {
            httpResponse.setSuccess(false);
            httpResponse.setError_msg("HTTP请求异常");
        }
        return httpResponse;
    }

    public HttpResponse post(String url,Map<String,String> params){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String,String> entry:params.entrySet()) {
            addParam(formBodyBuilder,entry);
        }
        RequestBody requestBody = formBodyBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            httpResponse.setSuccess(true);
            String result = response.body().string();
            httpResponse.setResult(result);
        } catch (Exception e) {
            httpResponse.setSuccess(false);
            httpResponse.setError_msg("HTTP请求异常");
        }
        return httpResponse;

    }

    //参数为json格式的post请求
    public HttpResponse post(String url,String json){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            httpResponse.setSuccess(true);
            String result = response.body().string();
            httpResponse.setResult(result);
        } catch (Exception e) {
            httpResponse.setSuccess(false);
            httpResponse.setError_msg("HTTP请求异常");
        }
        return httpResponse;
    }

    //带请求头的参数为json格式的post请求
    public HttpResponse post(String url,String json, Map<String,String> header){
        RequestBody body = RequestBody.create(JSON, json);
        Set<Map.Entry<String,String>> headerSet = header.entrySet();
        Request.Builder requestBuilder = new Request.Builder();
        for (Map.Entry<String,String> entry:headerSet) {
            addHeader(requestBuilder,entry);
        }
        Request request = requestBuilder
                .url(url)
                .post(body)
                .build();
        try {
            Response response = CLIENT.newCall(request).execute();
            httpResponse.setSuccess(true);
            String result = response.body().string();
            httpResponse.setResult(result);
        } catch (Exception e) {
            httpResponse.setSuccess(false);
            httpResponse.setError_msg("HTTP请求异常");
        }
        return httpResponse;
    }

    public static HttpClient getInstance(){
        return new HttpClient();
    }

    private String getParam(Map<String,String> params){
        return params.entrySet().stream()
                  .sorted(Map.Entry.comparingByKey())
                  .map(entry -> entry.getKey() + "=" + entry.getValue())
                  .collect(Collectors.joining("&"));
    }

    private void addHeader(Request.Builder builder,Map.Entry<String,String> entry){
         builder.addHeader(entry.getKey(),entry.getValue());
    }

    private void addParam(FormBody.Builder builder, Map.Entry<String,String> entry){
        builder.add(entry.getKey(),entry.getValue());
    }
}
