package zzy.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.util.List;

/**
 * ${导出excel文件}
 * cdzhuzhiyong
 * 2018/7/11 15:13
 **/
public class ExportExcel {
    //header:每一列列头 ; objects:每一行数据的集合
    public XSSFWorkbook exportExcel(String[] header,List<Object> objects){
        //创建Excel对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //创建表
        XSSFSheet sheet = xssfWorkbook.createSheet("mySheet");
        sheet.setDefaultColumnWidth(20);
        sheet.setDefaultRowHeightInPoints(20);
        //创建行
        XSSFRow row = sheet.createRow(0);
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
        // 添加表头数据
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        //填充数据
        for (int i=0; i<objects.size(); i++){
//            row = sheet.createRow(i+1);
//            row.createCell(0).setCellValue(developerList.get(i).getContactName());
//            row.createCell(1).setCellValue(developerList.get(i).getUserPin());
//            if (developerList.get(i).getType()==1){
//                row.createCell(2).setCellValue("企业");
//            }
//            else{
//                row.createCell(2).setCellValue("个人");
//            }
//            row.createCell(3).setCellValue(developerList.get(i).getContactMobile());
//            row.createCell(4).setCellValue(developerList.get(i).getDevEmail());
//            row.createCell(5).setCellValue(developerList.get(i).getApplication_time());
        }
        return xssfWorkbook;
    }
}
