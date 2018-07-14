package zzy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import zzy.okhttp.HttpClient;
import zzy.okhttp.HttpResponse;

import java.util.*;

public class TestHttp {
    @Test
    public void test(){
        String url = "http://api.interpreter.caiyunai.com/v1/translator";
        String fromTo = "zh2en";
        String token = "token cqcbbagr2siar9tirnmw";
        List<String> contentList = new ArrayList<>();
        contentList.add("我是你爸爸");
        PostData postData = new PostData(UUID.randomUUID().toString(),contentList,fromTo);
        String json = JSON.toJSONString(postData);
        Map map = new HashMap();
        map.put("X-Authorization",token);
        HttpResponse httpResponse = HttpClient.getInstance().post(url,json,map);
        System.out.println(httpResponse);
    }
}
