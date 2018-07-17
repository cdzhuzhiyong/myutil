package zzy;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import zzy.excel.AbstractExcelHandler;
import zzy.excel.ExportExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestExportExcel {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\my.xlsx");
        String[] header = new String[]{"name","stu_num","score"};
        XSSFWorkbook xssfWorkbook = ExportExcel.exportExcel(new Myhandler(header));
        xssfWorkbook.write(outputStream);
    }
}

class Myhandler extends AbstractExcelHandler{
    public Myhandler(String[] header){
        super(header);
    }
    @Override
    public XSSFWorkbook handle() {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("zzy","201531060592",85.5d);
        Student student2 = new Student("yq","201531060593",90d);
        Student student3 = new Student("xxx","201531060594",62d);
        studentList.add(student1);studentList.add(student2);studentList.add(student3);
        for (int i=0;i<studentList.size();i++){
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(studentList.get(i).getName());
            row.createCell(1).setCellValue(studentList.get(i).getNum());
            row.createCell(2).setCellValue(studentList.get(i).getScore());
        }
        return xssfWorkbook;
    }
}
