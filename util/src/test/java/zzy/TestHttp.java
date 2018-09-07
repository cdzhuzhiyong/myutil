package zzy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import zzy.okhttp.HttpClient;
import zzy.okhttp.HttpResponse;

import java.util.*;

public class TestHttp {
    @Test
    public void test(){
        String url = " https://www.youlai.cn/api/jd_skill";
        Map<String,String> map = new HashMap<>();
        map.put("keyword","感冒");
        map.put("long_word","怎么办");
        HttpResponse httpResponse = HttpClient.getInstance().post(url,map);
        System.out.println(httpResponse.getResult());
    }

}
