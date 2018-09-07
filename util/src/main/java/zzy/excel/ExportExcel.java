package zzy.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * ${导出excel文件}
 * cdzhuzhiyong
 * 2018/7/11 15:13
 **/

public class ExportExcel {
    private XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
    private XSSFRow row;
    private XSSFSheet sheet;
    private String[] header;
    public  XSSFWorkbook exportExcel(ExcelVo excelVo){
        header = excelVo.getHeaders();
        init();
        try {
            handleData(excelVo.getContentList());
        } catch (Exception e) {
            System.out.println("导出失败");
            e.printStackTrace();
        }
        return xssfWorkbook;
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

    private void handleData(List<Object> list) throws InvocationTargetException, IllegalAccessException {
        for (int i=0;i<list.size();i++){
            Object obj = list.get(i);
            Method[] methods = obj.getClass().getDeclaredMethods();
            Field[] fields = obj.getClass().getDeclaredFields();
            row = sheet.createRow(i+1);
            for (int k = 0; k < fields.length; k++) {
                String methodName = "get"+fields[k].getName();
                for (Method method:methods) {
                    if (method.getName().equalsIgnoreCase(methodName)) {
                        Object data = method.invoke(obj);
                        row.createCell(k).setCellValue(String.valueOf(data));
                    }
                }
            }

        }
    }

    public static ExportExcel builder(){
        return new ExportExcel();
    }
}
