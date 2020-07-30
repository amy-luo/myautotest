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


public class GetDataSimpleTest {
    protected static final Logger logger= LoggerFactory.getLogger(GetDataSimpleTest.class);
    public static void main(String[] args) {

        try {
            OkHttpClient client = new OkHttpClient();
            String host = "www.jisilu.cn";
            MediaType mediaType = MediaType.parse("application/json");
            String cookies = "kbzw__Session=fa7al5gmsneigfp0lccg70opu6; Hm_lvt_164fe01b1433a19b507595a43bf58262=1595926659; kbz_newcookie=1; kbzw_r_uname=avon_row; kbzw__user_login=7Obd08_P1ebax9aX2Njlz9bp4u-Cq47k2ujc8NvpxtS-otrWsJnWltqt2s6qz63Dp5KqrKaqlqPG1a2qm92hq8PXgrKk6OHFzr6fr6uisqWYnaO2uNXQo67f293l4cqooaWSlonE2Nbhz-TQ5-GwicLa68figcTY1piww4HMmaaZ2J2swaqKl7jj6M3VuNnbwNLtm6yVrY-qrZOgrLi1wcWhieXV4seWqNza3ueKkKTc6-TW3puvk6SRpaujrJWekqexlbza0tjU35CsqqqmlKY.; Hm_lpvt_164fe01b1433a19b507595a43bf58262=1595942201";
//            String[] installCert = {"www.jisilu.cn"};
//            InstallCert.main(installCert);
            int rp = 50;
            int fund_id = 510500;
            int page = 1;
            String content = "is_search=1&fund_id=" + fund_id + "&rp=" + rp + "&page=" + page;
            String url = "https://www.jisilu.cn/data/etf/detail/"+fund_id;
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
            String responseBody = response.body().string();
            JSONObject jsonResult = JSON.parseObject(responseBody);
            JSONArray rows = jsonResult.getJSONArray("rows");
            Map<String, Map<String, Object>> all_paramMap = new HashMap<>();
            for (int i = 0; i < rows.size(); i++) {
                String id = JSON.parseObject(rows.get(i).toString()).getString("id");
                JSONObject cell = JSON.parseObject(rows.get(i).toString()).getJSONObject("cell");
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("id", fund_id);
                paramMap.put("amount", cell.getInteger("amount"));
                paramMap.put("trade_price", cell.getInteger("trade_price"));
                paramMap.put("fund_nav", cell.getInteger("fund_nav"));
                paramMap.put("hist_dt", cell.getString("hist_dt"));
                paramMap.put("discount_rt", cell.getString("discount_rt"));
                paramMap.put("idx_incr_rt", cell.getString("idx_incr_rt"));
                paramMap.put("idb_pb", cell.getString("idb_pb"));
                paramMap.put("idb_pe", cell.getString("idb_pe"));
                paramMap.put("amount_incr", cell.getInteger("amount_incr"));
                paramMap.put("increase_rt", cell.getString("increase_rt"));
                all_paramMap.put(cell.getString("hist_dt"), paramMap);
            }
            logger.info(all_paramMap.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
