package com.mytest.ptbase.api.xueqiu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoiRead {
    protected static final Logger logger= LoggerFactory.getLogger(PoiRead.class);

    public ArrayList<String> getCodes(String filePath) throws IOException {
        ArrayList<String> codes = new ArrayList();
        ArrayList<String> names = new ArrayList();

        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        in.close();
//        FileOutputStream fos = new FileOutputStream(file);
//        XSSFWorkbook workbook1 = new XSSFWorkbook();
//        workbook1.write(fos);
//        fos.close();
        // 获得工作表个数
        int sheetCount = workbook.getNumberOfSheets();
        // 遍历工作表
        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            // 获得行数
            int rows = sheet.getLastRowNum() + 1;
            // 获得列数，先获得一行，在得到改行列数
            Row tmp = sheet.getRow(0);
            if (tmp == null) {
                continue;
            }
            for (int row = 1; row < rows-2; row++) {
                Row r = sheet.getRow(row);
                if(null!=r.getCell(0)){
                codes.add(r.getCell(0).toString());
                names.add(r.getCell(0).toString());
                }
            }

//            int cols = tmp.getPhysicalNumberOfCells();
            // 读取数据
//            for (int row = 0; row < rows; row++) {
//                Row r = sheet.getRow(row);
//                for (int col = 0; col < cols; col++) {
//                    System.out.printf("%10s", r.getCell(col).getStringCellValue());
//                }
//                System.out.println();
//            }
        }
        return codes;
    }
    public static void main(String[] args) throws IOException {
//      String filePath="D:\\通达信\\T0002\\export\\上证5020200730.xls";
//      String filePath="D:\\通达信\\T0002\\export\\沪深30020200730.xls";
        PoiRead poiRead=new PoiRead();
        String filePath="D:\\通达信\\T0002\\export\\中证50020200730.XLSX";
        poiRead.getCodes(filePath);
    }
}
