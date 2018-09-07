package zzy;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import zzy.excel.ExcelVo;
import zzy.excel.ExportExcel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        ExportExcel exportExcel = ExportExcel.builder();
        ExcelVo excelVo = new ExcelVo();
        Student student1 = new Student("zzy","201531",90);
        Student student2 = new Student("yq","201532",90);
        Student student3 = new Student("zxd","201533",90);
        List<Student> list = new ArrayList<>();
        list.add(student1); list.add(student2); list.add(student3);
        String[] header = new String[]{"姓名","学号","分数"};
        excelVo.setHeaders(header);
        excelVo.setContentList(list);
        XSSFWorkbook xssfWorkbook = exportExcel.exportExcel(excelVo);
        OutputStream outputStream = new FileOutputStream(new File("D:\\export.xlsx"));
        xssfWorkbook.write(outputStream);
        outputStream.close();
        xssfWorkbook.close();

    }
}
