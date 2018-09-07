package zzy.excel;

import java.util.List;

public class ExcelVo<T> {
    private String[] headers;
    private List<T> contentList;

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }
}
