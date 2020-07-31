package com.mytest.function.api.xueqiu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


public class GetDataEach {
    protected static final Logger logger= LoggerFactory.getLogger(GetDataEach.class);
    public Map<String, Map<String, Object>> getDataEach(String symbol,Long begin,String period,String type,int count,String indicator) {
        Map<String, Map<String, Object>> all_paramMap = new HashMap<>();
        try {
            OkHttpClient client = new OkHttpClient();
            String host = "stock.xueqiu.com";
            MediaType mediaType = MediaType.parse("application/json");
            String cookies = "device_id=05b513aaf86036bb7b255e5e98ec6365; xq_a_token=69a6c81b73f854a856169c9aab6cd45348ae1299; xqat=69a6c81b73f854a856169c9aab6cd45348ae1299; xq_r_token=08a169936f6c0c1b6ee5078ea407bb28f28efecf; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTU5ODMyMzAwNCwiY3RtIjoxNTk1OTkyOTU0NzM1LCJjaWQiOiJkOWQwbjRBWnVwIn0.dm4WsEyjUB-waZhHlmMpA2UqXfXm_xC35iudjKmiuSzSSfnxD6UIusRVpq5MaCoJ60DeVOt-VCnzTI0sXlHxwsRePJrFBV4SxBY-nlPfK5jcHTNkukpU-MjxdmlWQRaF8JymyCfOBw9iyfUEIVZkJvPXewLGjayo28hk4jpS307VH3VVRGZs6tM7ct8BAaSZFj_EET_3MXA8kJ2mifDR2HQIylxWCvaMUOLpHETuiiOYkk4XEyp2Br5KNsdS1IroUhqoztTE5SygtlFLNpvsEUVSk3kip4feA4kWbT53BClSVn5_gZZBXooo5aMYD_NxnzWO3ipaQb7pzEnc_wMCWQ; u=441595992985258; Hm_lvt_1db88642e346389874251b5a1eded6e3=1595396074,1595992987; s=cc1ae6i3xc; is_overseas=0; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1596082964";
//            String[] installCert = {"www.jisilu.cn"};
//            InstallCert.main(installCert);
            String url = "https://stock.xueqiu.com/v5/stock/chart/kline.json?symbol="+symbol+"&begin="+begin+"&period="+period+"&type="+type+"&count="+count+"&indicator="+indicator;
//            String content="";
//            RequestBody body = RequestBody.create(mediaType, content);
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Host", host)
                    .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36")
                    .addHeader("X-Requested-with", "XMLHttpRequest")
                    .addHeader("Referer", "https://stock.xueqiu.com/v5/stock/chart/kline.json")
//                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Accept-Encoding", "zh-CN,zh;q=0.9")
                    .addHeader("Cookie", cookies)
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            try {
                FileWriter fileWriter = null;
                fileWriter = new FileWriter("D:\\通达信\\T0002\\export\\xueqiuData.txt");//创建文本文件
                fileWriter.write(responseBody);//写入 \r\n换行
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("finish write");
            JSONObject jsonResult = JSON.parseObject(responseBody);
            String res_symbol=jsonResult.getJSONObject("data").getString("symbol");
            JSONArray column = jsonResult.getJSONObject("data").getJSONArray("column");
            JSONArray item = jsonResult.getJSONObject("data").getJSONArray("item");
            Map<String, Object> paramMap = new HashMap<>();
            for (int i = 0; i < item.size(); i++) {
                for (int j = 0; j < column.size(); j++) {
                    paramMap.put(column.get(j).toString(),((JSONArray)item.get(i)).get(j));
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String date=df.format(((JSONArray)item.get(i)).get(0));
                all_paramMap.put(date,paramMap);
            }
            logger.info(res_symbol+"的数据为: "+all_paramMap.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all_paramMap;
    }
    public static void main(String[] args){
        String symbol = "SH000905";
        Long begin = 1596169455875L;
        String period = "month";
        String type="before";
        int count=-304;
        String indicator="kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";
        GetDataEach getDataEach=new GetDataEach();
        getDataEach.getDataEach(symbol,begin,period,type,count,indicator);
    }

}
