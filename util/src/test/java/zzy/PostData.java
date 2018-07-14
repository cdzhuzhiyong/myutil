package zzy;

import lombok.Data;

import java.util.List;

@Data
public class PostData {
    //请求ID，任意取值
    private String request_id;
    //待翻译的内容
    private List<String> source;
    //从什么语言翻译成什么语言
    private String trans_type;

    public PostData(String request_id, List<String> source, String trans_type) {
        this.request_id = request_id;
        this.source = source;
        this.trans_type = trans_type;
    }

}
