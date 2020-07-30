package com.mytest.function.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiWriteUtil {
        public void poiWrite(String filePath) throws IOException
        {
            // 创建工作薄
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 创建工作表
            XSSFSheet sheet = workbook.createSheet("sheet1");

            for (int row = 0; row < 10; row++)
            {
                XSSFRow rows = sheet.createRow(row);
                for (int col = 0; col < 10; col++)
                {
                    // 向工作表中添加数据
                    rows.createCell(col).setCellValue("data" + row + col);
                }
            }
            File file=new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
        }
}
