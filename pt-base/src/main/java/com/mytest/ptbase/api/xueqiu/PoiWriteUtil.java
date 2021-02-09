package com.mytest.ptbase.api.xueqiu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiWriteUtil {
        public void poiWrite(String filePath, Map<String, ArrayList<BigDecimal>> dateMap) throws IOException
        {
            // 创建工作薄
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 创建工作表
            XSSFSheet sheet = workbook.createSheet("sheet2");
            XSSFRow row0 = sheet.createRow(0);
            // 向工作表中添加数据
            row0.createCell(0).setCellValue("date");
            row0.createCell(1).setCellValue("PE算术平均值");
            row0.createCell(2).setCellValue("PE加权平均值");
            row0.createCell(3).setCellValue("PB算术平均值");
            row0.createCell(4).setCellValue("PB加权平均值为");
            row0.createCell(5).setCellValue("当前等权PE百分位");
            row0.createCell(6).setCellValue("当前加权PE百分位");
            row0.createCell(7).setCellValue("当前等权PB百分位");
            row0.createCell(8).setCellValue("当前加权PE百分位");
            int i=1;
            for (Map.Entry entry:dateMap.entrySet()){
            if(entry.getKey().equals("PE百分位")){
                row0.createCell(5).setCellValue("当前等权PE百分位= "+((ArrayList<Object>) (entry.getValue())).get(0).toString());
                row0.createCell(6).setCellValue("当前加权PE百分位= "+((ArrayList<Object>) (entry.getValue())).get(1).toString());
                row0.createCell(7).setCellValue("当前等权PB百分位= "+((ArrayList<Object>) (entry.getValue())).get(2).toString());
                row0.createCell(8).setCellValue("当前等权PB百分位= "+((ArrayList<Object>) (entry.getValue())).get(3).toString());
            }

            if(!entry.getKey().equals("PE百分位")){
                XSSFRow rows = sheet.createRow(i++);
                for (int col = 0; col < 5; col++) {
                    // 向工作表中添加数据
                    if(col==0) {
                        rows.createCell(col).setCellValue(entry.getKey().toString());
                    }
                    if(col!=0) {
                    rows.createCell(col).setCellValue(((ArrayList<Object>) (entry.getValue())).get(col-1).toString());
                    }
                }
            }
            }
            File file=new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
        }
}
