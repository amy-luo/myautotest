package com.mytest.function.api.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;
import org.testng.Assert;
import org.testng.collections.CollectionUtils;
import java.util.Map;

public abstract class BaseInterfaceApi {

    private String contentType = "application/json";
    private JSONObject resultJSon;
    private boolean status;
    private int resultStatus;
    protected abstract String getParam();
    protected abstract String getUrl();
    protected abstract Map<String,String> getResponseCheck();
    protected abstract Headers getHeaders();
    public BaseInterfaceApi call(){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse(contentType);
        RequestBody body = RequestBody.create(mediaType, getParam());
        Request request = new Request.Builder()
                .url(getUrl())
                .post(body)
                .headers(getHeaders())
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            JSONObject jsonObject = JSON.parseObject(responseBody);
            resultStatus = jsonObject.getIntValue("resultStatus");
            resultJSon = jsonObject.getJSONObject("result");
            if(null != resultJSon){
                status = resultJSon.getBoolean("success");
            }
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false,"the api happen exception");
        }
        return this;
    }
    public void successCheck(){
        org.testng.Assert.assertTrue(status, "status is incorrect");
        org.testng.Assert.assertTrue(resultStatus == 1000, "resultStatus is incorrect");
    }
    public void failCheck(){
        org.testng.Assert.assertFalse(status, "status is incorrect");
        org.testng.Assert.assertTrue(resultStatus == 1000, "resultStatus is incorrect");
    }

    public void defaultResponseCheck(){
        if(CollectionUtils.hasElements(getResponseCheck())){
            for(String key:getResponseCheck().keySet()){
                String expect = getResponseCheck().get(key);
                String actual = null;
                if(key.indexOf(".")==-1){
                    actual = getResponseCheck().get(key);
                }else{
                    String []objArray = key.split("\\.");
                    Object baseObject = resultJSon;
                    for(String name:objArray){
                        JSONObject baseJSONObject = (JSONObject) baseObject;
                        baseObject = baseJSONObject.get(name);
                    }
                    if(baseObject instanceof String){
                        actual = baseObject.toString();
                    }
                }
                org.testng.Assert.assertEquals(expect,actual,String.format("the %s values is error expect [%s] actual [%s]",key,expect,actual));
            }
        }
    }

    public void checkResult(Map<String,String> checkPoint){

    }

    public JSONObject getResultJSon() {
        return resultJSon;
    }
}
