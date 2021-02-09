package com.mytest.ptbase.api.xueqiu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SearchCode {
    protected static final Logger logger= LoggerFactory.getLogger(PE_PB_Time.class);
    public ArrayList<String> searchCode(ArrayList<String> codes) throws IOException {
        ArrayList<String> codeWithHeads = new ArrayList<>();
        for (String code : codes) {
            String code_format=code.substring(1,7);
            OkHttpClient client = new OkHttpClient();
            String host = "xueqiu.com";
            MediaType mediaType = MediaType.parse("application/json");
            String cookies = "device_id=05b513aaf86036bb7b255e5e98ec6365; xq_a_token=69a6c81b73f854a856169c9aab6cd45348ae1299; xqat=69a6c81b73f854a856169c9aab6cd45348ae1299; xq_r_token=08a169936f6c0c1b6ee5078ea407bb28f28efecf; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTU5ODMyMzAwNCwiY3RtIjoxNTk1OTkyOTU0NzM1LCJjaWQiOiJkOWQwbjRBWnVwIn0.dm4WsEyjUB-waZhHlmMpA2UqXfXm_xC35iudjKmiuSzSSfnxD6UIusRVpq5MaCoJ60DeVOt-VCnzTI0sXlHxwsRePJrFBV4SxBY-nlPfK5jcHTNkukpU-MjxdmlWQRaF8JymyCfOBw9iyfUEIVZkJvPXewLGjayo28hk4jpS307VH3VVRGZs6tM7ct8BAaSZFj_EET_3MXA8kJ2mifDR2HQIylxWCvaMUOLpHETuiiOYkk4XEyp2Br5KNsdS1IroUhqoztTE5SygtlFLNpvsEUVSk3kip4feA4kWbT53BClSVn5_gZZBXooo5aMYD_NxnzWO3ipaQb7pzEnc_wMCWQ; u=441595992985258; Hm_lvt_1db88642e346389874251b5a1eded6e3=1595396074,1595992987; s=cc1ae6i3xc; is_overseas=0; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1596082964";
//            String[] installCert = {"www.jisilu.cn"};
//            InstallCert.main(installCert);
            String url = "https://xueqiu.com/stock/search.json?code=" + code_format + "&size=3&page=1";
//            String content="";
//            RequestBody body = RequestBody.create(mediaType, content);
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Host", host)
                    .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36")
                    .addHeader("X-Requested-with", "XMLHttpRequest")
                    .addHeader("Referer", "https://xueqiu.com/k?q="+code_format)
//                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Accept-Encoding", "zh-CN,zh;q=0.9")
                    .addHeader("Cookie", cookies)
                    .build();
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            JSONObject jsonResult = JSON.parseObject(responseBody);
            String codeWithHead = JSON.parseObject(jsonResult.getJSONArray("stocks").get(0).toString()).getString("code");
            codeWithHeads.add(codeWithHead);
        }
        return codeWithHeads;
    }
}
