package com.mytest.function.api.jisilu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GetDataTest {
    protected static final Logger logger= LoggerFactory.getLogger(GetDataTest.class);
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();
            String host = "www.jisilu.cn";
            MediaType mediaType = MediaType.parse("application/json");
            String cookies = "kbzw__Session=fa7al5gmsneigfp0lccg70opu6; Hm_lvt_164fe01b1433a19b507595a43bf58262=1595926659; kbz_newcookie=1; kbzw_r_uname=avon_row; kbzw__user_login=7Obd08_P1ebax9aX2Njlz9bp4u-Cq47k2ujc8NvpxtS-otrWsJnWltqt2s6qz63Dp5KqrKaqlqPG1a2qm92hq8PXgrKk6OHFzr6fr6uisqWYnaO2uNXQo67f293l4cqooaWSlonE2Nbhz-TQ5-GwicLa68figcTY1piww4HMmaaZ2J2swaqKl7jj6M3VuNnbwNLtm6yVrY-qrZOgrLi1wcWhieXV4seWqNza3ueKkKTc6-TW3puvk6SRpaujrJWekqexlbza0tjU35CsqqqmlKY.; Hm_lpvt_164fe01b1433a19b507595a43bf58262=1595942201";
            String url = "https://www.jisilu.cn/data/etf/etf_list/?___jsl=LST___t="+System.currentTimeMillis()+"&rp=25&page=1";
            int rp=25;
            int page=1;
            String ___jsl="LST___t="+System.currentTimeMillis();
            String content = "___jsl="+___jsl+"&rp="+rp+"&page="+page;
            RequestBody body = RequestBody.create(mediaType, content);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Host", host)
                    .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36")
                    .addHeader("X-Requested-with", "XMLHttpRequest")
                    .addHeader("Referer", "https://www.jisilu.cn/data/etf/")
//                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Accept-Encoding", "zh-CN,zh;q=0.9")
                    .addHeader("Cookie", cookies)
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody=response.body().string();
            JSONObject jsonResult= JSON.parseObject(responseBody);
            JSONArray rows=jsonResult.getJSONArray("rows");
            Map<String,Map<String,Object>> all_paramMap=new HashMap<>();
            for(int i=0;i<rows.size();i++){
            String id=JSON.parseObject(rows.get(i).toString()).getString("id");
            JSONObject cell=JSON.parseObject(rows.get(i).toString()).getJSONObject("cell");
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("amount",cell.getIntValue("amount"));
            paramMap.put("creation_unit",cell.getIntValue("creation_unit"));
                paramMap.put("discount_rt",cell.getString("discount_rt"));
                paramMap.put("estimate_value",cell.getString("estimate_value"));
                paramMap.put("fee",cell.getString("fee"));
                paramMap.put("fund_id",cell.getString("fund_id"));
                paramMap.put("fund_nav",cell.getString("fund_nav"));
                paramMap.put("fund_nm",cell.getString("fund_nm"));
                paramMap.put("increase_rt",cell.getString("increase_rt"));
                paramMap.put("index_id",cell.getString("index_id"));
                paramMap.put("index_increase_rt",cell.getString("index_increase_rt"));
                paramMap.put("index_nm",cell.getString("index_nm"));
                paramMap.put("issuer_nm",cell.getString("issuer_nm"));
                paramMap.put("last_dt",cell.getString("last_dt"));
                paramMap.put("last_est_time",cell.getString("last_est_time"));
                paramMap.put("last_time",cell.getString("last_time"));
                paramMap.put("nav_dt",cell.getString("nav_dt"));
                paramMap.put("owned",cell.getInteger("owned"));
                paramMap.put("pb",cell.getString("pb"));
                paramMap.put("pe",cell.getString("pe"));
                paramMap.put("price",cell.getString("price"));
                paramMap.put("unit_incr",cell.getString("unit_incr"));
                paramMap.put("unit_total",cell.getString("unit_total"));
                paramMap.put("urls",cell.getString("urls"));
                paramMap.put("volume",cell.getString("volume"));
                all_paramMap.put(id,paramMap);
            }
            logger.info(all_paramMap.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
