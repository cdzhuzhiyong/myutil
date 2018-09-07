package zzy;

import org.apache.commons.io.input.BOMInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public List<String> get(String path) throws IOException {
        File filename = new File(path); // 要读取以上路径的txt文件
        InputStream inputStream = new FileInputStream(filename);
        BOMInputStream bomInputStream = new BOMInputStream(inputStream);
        List<String> list = new ArrayList<>();
        InputStreamReader reader = new InputStreamReader(
                bomInputStream,"UTF-8"); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line;
        line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine(); // 一次读入一行数据
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        String path = "E:\\chrome\\export.txt";
        List<String> list = new Test().get(path);
        Set<String> set = new HashSet<>();
        set.addAll(list);
        for (String s:list) {
            System.out.print(s+":"+s.trim().length());
        }
        System.out.println();
        System.out.println("============");
        for (String s:set) {
            System.out.print(s+":"+s.length());
        }
    }
}


