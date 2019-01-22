package zzy.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ${字符串操作封装}
 * cdzhuzhiyong
 * 2018/7/3 20:50
 **/
public class StringUtils {
    /**
     * ${http GERT请求时将传参拼接成 key1=value1&key2=value2 格式}
     * cdzhuzhiyong
     * 2018/7/3 20:47
     **/
    public static String getString(Map<String,String> params){
        return params.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(entry -> entry.getKey()+"="+entry.getValue())
                    .collect(Collectors.joining("&"));
    }

    /**
     * ${判断字符串为空}
     * cdzhuzhiyong
     * 2018/7/3 20:48
     **/
    public static boolean isEmpty(String element){
        return element == null || element.trim().length() <=0;
    }
    /**
     * ${判断字符串不为空}
     * cdzhuzhiyong
     * 2018/7/3 20:49
     **/
    public static boolean isNotEmpty(String element){
        return !isEmpty(element);
    }

    /**
     * ${按切割符切割字符串返回List集合}
     * cdzhuzhiyong
     * 2018/8/24 16:19
     **/
    public static List<String> getListBySplit(String content,String delimiter){
        if (isNotEmpty(content)&&content.contains(delimiter)){
            return Arrays.asList(content.split(delimiter));
        }
        return null;
    }
}
