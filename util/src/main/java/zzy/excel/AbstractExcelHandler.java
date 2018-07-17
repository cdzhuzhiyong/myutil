package zzy.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

public abstract  class AbstractExcelHandler implements ExcelHandler{
    private String[] header;
    protected XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
    protected XSSFRow row;
    protected XSSFSheet sheet;
    public AbstractExcelHandler(String[] header){
        this.header = header;
        init();
    }
    private void init(){
        sheet = xssfWorkbook.createSheet("mySheet");
        sheet.setDefaultColumnWidth(20);
        sheet.setDefaultRowHeightInPoints(20);
        //设置excel表格样式
        XSSFCellStyle style = xssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        // 设置边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        // 生成一个字体
        XSSFFont font = xssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        font.setFontName("宋体");
        // 把字体 应用到当前样式
        style.setFont(font);
        //创建行
        row = sheet.createRow(0);
        // 添加表头数据
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
    }
}
