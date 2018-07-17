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
/**
 * 继承AbstractExcelHandler类，传入Header数组，实现ExceHandler的handle方法
 * 在handler方法 row = sheet.createRow(i+1)创建存放数据的行
 * row.createCell(index).setCellValueindex()存放对应的表头数据，index指Header数组中值的索引
 * */
public class ExportExcel {
    public static  XSSFWorkbook exportExcel(ExcelHandler handler){
        return handler.handle();
    }
}
