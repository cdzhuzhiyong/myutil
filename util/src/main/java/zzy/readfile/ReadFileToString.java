package zzy.readfile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * ${读取classPath下的文件内容，返回字符串}
 * cdzhuzhiyong
 * 2018/6/30 21:23
 **/
public class ReadFileToString {
    private static URI getFile(String path) throws URISyntaxException {
        URL url = ReadFileToString.class.getClassLoader().getResource(path);
        return Objects.requireNonNull(url).toURI();
    }

    public String getFileContentToString(String classPath) throws URISyntaxException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(getFile(classPath))),StandardCharsets.UTF_8);
        return content;
    }
}
