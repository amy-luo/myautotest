package com.mytest.function.api.login;

import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
@CCHost
public class LoginTest {
    protected static final Logger logger= LoggerFactory.getLogger(LoginTest.class);
    @CCPrepare(id="LoginTest")
    public static Map<String,Object> login(Map<String,Object> paramMap){
        paramMap.toString();
        String phoneNumber=(String)paramMap.get("phoneNumber");
        String password=(String)paramMap.get("password");
        HashMap<String,Object> ownParamMap=(HashMap<String,Object>)paramMap.get("ownParamMap");
        String ctoken=(String) ownParamMap.get("ctoken");
        String userId=(String) ownParamMap.get("userId");
        HashMap<String,Object> merchantInfo=(HashMap<String,Object>)ownParamMap.get("merchantInfo");
        String merchantId=(String) merchantInfo.get("merchantId");
        String shopName=(String) merchantInfo.get("shopName");
        int maxAmount=(int) merchantInfo.get("maxAmount");

//        String contentType = "application/json";
//        String url="http://msg-gw.aphome.id.sit.alipay.net/mgw.htm";
//        StringBuilder cookies=new StringBuilder("");
//        if(null!=(paramMap.get(""))){
//            cookies.append(""+paramMap.get(""));
//        };
//        String param = "ts=" + System.currentTimeMillis() / 1000 + "&requestData=%5B%7B%22envInfo%22%3A%7B%22locationInfo%22%3A%7B%22latitude%22%3A%2231.235783585793037%22%2C%22longitude%22%3A%22121.50126829688627%22%2C%22updateTime%22%3A1544149695195%2C%22type%22%3A%22GPS%22%2C%22status%22%3A%220%22%7D%2C%22tokenId%22%3A%22yqycgaj8i%2FqlTSUarmt4jMupp07vLxRfi6WnsuAwHJJ93miBZwEAAA%3D%3D%22%2C%22sourcePlatForm%22%3A%22MAIN_APP%22%2C%22terminalType%22%3A%22APP%22%2C%22osType%22%3A%22ios%22%2C%22osVersion%22%3A%2212.1.1%22%2C%22cashierSdkVersion%22%3A%221.1.0%22%2C%22appVersion%22%3A%220.3.3%22%2C%22clientKey%22%3A%22mQrhvh67n%2F6uv9hBJ%2Fh04aWvdbXevJHBYT%2F8foncE9BBPsNkfIG1vs%2BlHY9crNIo%22%2C%22locale%22%3A%22en_US%22%2C%22extendInfo%22%3A%7B%22rdsJsonUa%22%3A%22%7B%5C%22version%5C%22%3A%5C%222%5C%22%2C%5C%22data%5C%22%3A%5C%22f153812d4304000000000000215ba3caba52812af16c6e6ffd080ee0cc52be078e7e336383cbbaf32b0e3b32982a0e8967cba0ca3c916cb78bf6e8d5966750d51e8903fe19f9dba01b5f0a5bbc87e1fda6734b289c366c874b286559eacff651a4f9a2536aa3efd113fe98b2bec885674476654f4a898e42874740a4400746429ac0f250611555812267895981bf93c761dc87e433408f54cc12314205a80bc3b523788c6b6b85167e9f9bd4ad7250e457c869e422596b42c91b375210ae3c52076a15a53a5d144b27604e355f4e534cd893dd9301429261c617a62971b7a591468b30e566ac87b86ac1548fd6f429ced1c479f5582d50a772ae5baad84ba28895379d0f999850727e7d997f7fad52f24a2cd19548034ffb4e07e9125fe91d11aa6adc68f0191c2e85d21e3aabb4e7944c6ddc93a05285f96cec706bbc748d6f3afdfc093719afd35021bec630c9c94d1716170fc1f9b86be8c5fc32d2eec96b2e3477aa88b2ee12d16d6b0674999b3870b7afac231e17c43ef6627d57973761d196cc84e879a8e39b3c7577201aec1c046a2119c3ec3810dc203cc594db36050c89b810d52e779fd9dcc21cda1504dca1e379cc19d16be0b404b7546ad464093714ec24f095129286a3073833ae1fe2550cce159f293f213307eca764e5d4b84840ae1b48a4046bc34c2e166285db85afabf68266a833e3d56e689c0e1f21733438094910345ac46978f0f6e55ab4f3f1edc3f0f3fb8f49158b869d3e09370c437eb9d6cd71cc59618513ddc371d10b37a7d4bf440586acf09cb48048578eac1721e013d76a19bf38ae3f2a822fba8c895410758821e78771c03cc827f2cf9aecf46b69e5eff6d61d9c18359ad3928189abd4f3e3273afcf84fa29b314aa57643829bfb92d2b73ef2cb6ab3875e2d72c370e2863f68804acc8cd91c27cbea430910fd1b27c5d4378df69a9015d4d28b0045cd204448a75ec43d5e193f5ec4b41f1bc20f65fba0a7706e76cab4da8d4d7b157b5da23ba33e0498d08d3d780b0067fe09774b224e7c18bf940f0113bf0be8c78cdd796003112414bc557940221a2e88d3cfbff922952d1a40e2df6b17c33d03e18ccfbeddc77e6966af23c7e8d96ec230e3fca88176112d6b4989b1336a6d5322f26d5366243ce385c6d0867c0f342364bf6ae6aff48c3724246c568baf55498003781b630f838f46cdda7c828a69d20f45a7d97d5a29d75ada64c4b4a01e74a1cac7bec4fdefa1f588fbdda04c6bda4cf2bce5622ddb374205ea647e31cc21e9bccd101ad895abd190e9c924dd0aa76e6e7b169baeb6eb95fce2c43e3ec319f9946fb4052037bc60b37ed8f973fb413cd07e2d9cc3f10b84e8c5178f10a28091af45918cee0154040233220b468c5545aca7e6cc7ad4ad958fbb019f51f7b98cb3a4d8c0e558a3daf72b25563eab7047bee2016121298ef593f6db5f2f10461160f4291ca4e05b724affb29b496c493f2281c27e59e764332413b88dd5d3baef1191b6e401ba734eda9f782b8c65d73a8e70fec532775863d8e03fbbd894bc54906d48a7b11ba507144b61c5b25bafb3501de73db8804ef568e408a1476582b471db87fb71e7d568d7ba86dfc2f1c6423748df50a90e70e4dfbf4c93d58ce5f5eba346a19c012e8aa7525c6ecdfd36ecebb373a39c4ae35b21ed63f2669c46bb83d01e900f3960a93f537ce712efe248c7b0eb9c9efca65b8e5eecf597d80db174e407b7330c0b8d8c7edd9cba392d54cbf53a97b0ebe9fff245eddcafb0fb77014192ec57987d3621751a3a80ea739472078a6c819ad9259b7f84df5c2cbc541d48ed613acd7f86deac01beb583d46c3a95e0970e3c7ec8bb35ef71d0b27f233533a41d1e52f57055a787386f17c3ff339fa49cc251d0f55b8a7b1023ae7267e332cfcef14e466331e5e19c39649446ed8d1a2b1138fc8abc7695ba9f15a0a0b852c9db6c50b02b3091158bb5b6107fe5b9320759a3b8ab6189338d038ead4858a89aba7639210a99ab74efc369fc28367f8eca59f4bcb958cb18d507adb4e0dcff94bd7df1bae9c1775ac42aadf9bac47a2972d3de9da97211362019a438841d608022048733872244544255956062e0c2516b13b534f9d013ce3625d05e5e5eb4021a307b3b660e0000a34e69c89f775fcf63533fa6f42baaf1c33b39e1%5C%22%7D%22%7D%7D%2C%22loginType%22%3A%22NORMAL_LOGIN%22%2C%22loginId%22%3A%2262-" + paramMap.get("phoneNumber") + "%22%2C%22loginIdType%22%3A%22MOBILE_NO%22%2C%22credentials%22%3A%22P33MtM74RHhCWmgBLBwl5ypp%2FOdfyDLec6aM5hOxFnF%2BFJ273YHT5zdbQL50DtNoynAIWRtua6aMvUHYN2pvs0uW9bwQBMTG5AsiO%2FXxwXKiJg1Dp3%2BVh66M%2FXDk25%2FLUQn7exwrdmxTtB%2F8LLN%2FH5mEUWqJKqw%2BAIN2DiAqTuPRJ8D5inNFbWZnUVPSdhWFnWCm8qmFdFPIwKc9D7O9Xa1B00xxNZWULxBkNotFclYPUe2reFrF8FEbsXwPSAB1CoRfYcTjXUqzRPlvYK6a7bMOqwZ2QxLQnckcJG3nZOavyhWvj0w6yPIG4UNUxWn7ANuvUy1xSumPRrLGwLOj0A%3D%3D%22%7D%5D&operationType=alipayplus.mobilewallet.user.login";
//        try {
//            OkHttpClient client = new OkHttpClient();
//            MediaType mediaType = MediaType.parse(contentType);
//            RequestBody body = RequestBody.create(mediaType, param);
//            Request request = new Request.Builder()
//                    .url(url)
//                    .post(body)
//                    .addHeader("Host", "mgs-gw.aphome.sit.dana.id")
//                    .addHeader("appId", "2D005CA271131")
//                    .addHeader("workspaceId", "sit")
//                    .addHeader("version", "2.0")
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
//                    .addHeader("Accept", "*/*")
//                    .addHeader("clientId", "460011600687774|865931020177465")
//                    .addHeader("Accept-Language", "en-US")
//                    .addHeader("Accept-Encoding", "gzip, deflate")
//                    .addHeader("OPERATION-TYPE", "alipayplus.mobilewallet.user.login")
//                    .addHeader("Content-Length", "762")
//                    .addHeader("did", "W/y7PYLFpD4DAIAW1vcOHgmY")
//                    .addHeader("tenantId", "unset")
//                    .addHeader("ts", "1544009617477")
//                    .addHeader("User-Agent", "Skywalker/1 CFNetwork/975.0.3 Darwin/18.2.0")
//                    .addHeader("Connection", "keep-alive")
//                    .addHeader("cache-control", "no-cache")
//                    .addHeader("Postman-Token", "e912247e-5138-4363-85aa-4a591a054a11")
//                    .addHeader("Cookie",cookies.toString())
//                    .build();
//
//            Response response = client.newCall(request).execute();
//            String responseBody = response.body().string();
//            JSONObject jsonObject = JSON.parseObject(responseBody);
//            Boolean status=jsonObject.getBoolean("success");
//            int resultStatus = jsonObject.getIntValue("resultStatus");
//            JSONObject resultJSon = jsonObject.getJSONObject("result");
//            if(null != resultJSon){
//                org.testng.Assert.assertTrue(status, "status is incorrect");
//                org.testng.Assert.assertTrue(resultStatus == 1000, "resultStatus is incorrect");
//            }
//    }catch (Exception e){
//        e.printStackTrace();
//        Assert.assertTrue(false,"the api happen exception");
//    }
        paramMap.put("login","test");
        paramMap.toString();
    return paramMap;
    }
}

