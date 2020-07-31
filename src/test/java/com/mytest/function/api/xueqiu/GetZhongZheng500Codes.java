package com.mytest.function.api.xueqiu;

import java.io.IOException;
import java.util.ArrayList;

public class GetZhongZheng500Codes {
    //      String filePath="D:\\通达信\\T0002\\export\\上证5020200730.xls";
//      String filePath="D:\\通达信\\T0002\\export\\沪深30020200730.xls";
    public ArrayList<String> codesForZhongZheng500(String filePath) throws IOException {
        ArrayList<String> codesFor500 = new ArrayList<>();
        PoiRead poiRead = new PoiRead();
//        String filePath = "D:\\通达信\\T0002\\export\\中证50020200730.XLSX";
        ArrayList<String> codes = poiRead.getCodes(filePath);
        SearchCode searchCode = new SearchCode();
        codesFor500=searchCode.searchCode(codes);
        return codesFor500;
    }
}
