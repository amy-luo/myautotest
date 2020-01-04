package com.mytest.function.api.register;

import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@CCHost
public class CheckRegisteredUserAndSendOTPTest {
    protected static final Logger logger= LoggerFactory.getLogger(CheckRegisteredUserAndSendOTPTest.class);
    @CCPrepare(id="CheckRegisteredUserAndSendOTPTest")
    public static Map<String,Object> checkRegisteredUserAndSendOTP(Map<String,Object> paramMap){
//        try {
//        OkHttpClient client=new OkHttpClient();
//        String url="";
//        MediaType mediaType=MediaType.parse("application/json");
//        String cookies="";
//        String content="";
//        RequestBody body=RequestBody.create(mediaType,content);
//        Request request=new Request.Builder()
//                .url(url)
//                .post(body)
//                .addHeader("","")
//                .addHeader("cookies",cookies)
//                .build();
//        Response response= null;
//
//            response = client.newCall(request).execute();
//
//        String responseBody=response.body().string();
//        JSONObject jsonObject=JSON.parseObject(responseBody);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        paramMap.put("1","1");

        return paramMap;
    }




}




