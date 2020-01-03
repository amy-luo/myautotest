package com.mytest.function.api.otp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yuyi191762 on 2018/12/10.
 * 正常登陆
 */
@CCHost
public class CheckRegisteredUserAndSendOTPApi {

    @CCPrepare(id="CheckRegisteredUserAndSendOTPApi")
    public static Map<String,String> checkRegisteredUserAndSendOTP(Map<String,String> paramMap){
        try {
        OkHttpClient client=new OkHttpClient();
        String url="";
        MediaType mediaType=MediaType.parse("application/json");
        String cookies="";
        String content="";
        RequestBody body=RequestBody.create(mediaType,content);
        Request request=new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("","")
                .addHeader("cookies",cookies)
                .build();
        Response response= null;

            response = client.newCall(request).execute();

        String responseBody=response.body().string();
        JSONObject jsonObject=JSON.parseObject(responseBody);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return paramMap;
    }




}




