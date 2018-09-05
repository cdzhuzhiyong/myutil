package zzy.readfile;

import org.apache.commons.io.input.BOMInputStream;
import zzy.string.StringUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ReadFileToString {
    private static URI getFile(String path) throws URISyntaxException {
        URL url = ReadFileToString.class.getClassLoader().getResource(path);
        return Objects.requireNonNull(url).toURI();
    }
    /**
     * ${读取classPath下的文件内容，返回字符串}
     * cdzhuzhiyong
     * 2018/6/30 21:23
     **/
    //主要针对读取json文件
    public static String getFileContentToStringByJson(String classPath){
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(getFile(classPath))),StandardCharsets.UTF_8);
            return content;
        } catch (Exception e) {
            return content;
        }
    }

    /**
     * ${读取绝对路径下的文件内容，返回字符串}
     * cdzhuzhiyong
     * 2018/8/24 14:38
     **/
    // \r\n 回车换行  \r 换行
    //读取换行的文本文件以~间隔
    public static String getFileContentToStringByTxt(String path){
        StringBuffer stringBuffer = new StringBuffer();
        try{
            File filename = new File(path); // 要读取以上路径的txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line;
            line = br.readLine();
            while (line != null) {
                stringBuffer.append(line);
                stringBuffer.append("~");
                line = br.readLine(); // 一次读入一行数据
            }
            if (StringUtils.isNotEmpty(stringBuffer.toString())){
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("~"));
            }
            return stringBuffer.toString();
        }catch(Exception e){}
        return null;
    }

    public InputStream getInputStreamWhithOutBOM(InputStream inputStream){
        BOMInputStream bomInputStream = new BOMInputStream(inputStream);
        return bomInputStream;
    }
}
