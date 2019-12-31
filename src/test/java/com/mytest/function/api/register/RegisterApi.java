package com.mytest.function.api.register;

import com.mytest.function.api.base.BaseInterfaceApi;
import com.squareup.okhttp.Headers;

import java.util.HashMap;
import java.util.Map;

public class RegisterApi extends BaseInterfaceApi {

    private Map<String,Object> paramMap;
    private String url="http://msg-gw.aphome.id.sit.alipay.net/mgw.htm";

    protected String getParam() {
        return "id=1953&operationType=alipayplus.mobilewallet.user.register.normalRegister&requestData=%5B%7B%22envInfo%22%3A%7B%22appVersion%22%3A%220.8.0-sit-debug%22%2C%22clientIp%22%3A%22%22%2C%22clientKey%22%3A%228E23B8D8FB2B239DC9152F1E87C1354F6592F12E3485A61EC501B2AAA265AEBFC981195ACA925BD7818CABD9026E8797EEA971E99479301F875B8E02972B73D4%22%2C%22extendInfo%22%3A%7B%22rdsJsonUa%22%3A%22%7B%5C%22version%5C%22%3A%5C%222%5C%22%2C%5C%22data%5C%22%3A%5C%22ed71213ceca7faa9f8abfeadffd6756ad4f38dedae791ffd3d6229ffb95d3470ff70082e7d2f7eba598498f80ea7ee78badf021f83c7701c45bddd49ec1aae476ad3cf68725d53452710c4201e0ed6120b2a6e029ab76e412f4577ec689eb3894595e0dd5d658a9387e4e92229e7a3ea265dab55d9ec3e43a96a47be5b46cac87dcbfe886f46dd2fad4f664022d3b5eaeea563252b3bf6131bc52c74aceb90ed900ea28715d04a2d02eeec031e638fd4ceccd828a419637ac4944e092739f38a5b17d7cc1277d65105bc520ccbc5f292f31a95a26a5557987a25afcfb5a1b4a624617af3ec1a5a6c18c42809ec57422b133efdb457d00ce059a96fb87a908789745e7e01c76ca57852b871e867015e06148b8ef11c42f93d633901ccdddf61278dd357c3178f0dddbd5be67b21c5aea9f4ddcd08ba0712004928aecc545ef52b885d993d2c6a0f0385cbdf889afbb96d15230b8e2c53a1a14d55e7ee46ed4460ed3181ad90d4e7c14cf027cf5910255784b7375a814b864bad236a002faf98ecfe1887681888138383c4851e8d9104d551545f5efda0951275f2e78b6b67cd065d422ee710be7fe4593ab162bab4de2f7e03b86832d6a562cabd1d4684c609f0aecd27063c8bccbcff2aecb0b2b7332c4fa0c7979b47264cb8f078b4f64565e1a3e95a6d5480edaea8374164d78c60091a34f14234bc13c1e8a7aacc8a6cc48e37082c374010d9a810ff4b9f4067224380cfe9861572ae4f66ec4253b12f878d101944d8732e0954c565d3d83b80a3c5210da115037dcca29ac0894cbe4a32af2a0d580765b8b1d43380e3cf5839a2657e128f497df76662a7cbc64cbe315e27c36174a12544c1c1e5f0027ecf723626dc534f2040137620d1206539a0225e4c2ec04ecce878a393e64be1f0d36e444b6a3531b21f827e46d9dcd953268d44b8e952764d0eca6f7b8a4292e126cfefd5eacca710c8d15fe62f9fea3a57025b4ee0299c0b71550a70e3cc6245344706046f7f7b30068dbd2c8b3c67e6bdb02c4f613d732a9644478edc4b55319ebbf4b142762b0f977ec694975044cffd9eb1fa7da8803f5706c920fffa05569c9e20696aa3f6c29ca9f019f91c56de42f7f392b8b2110de101eb06275d1a7740f34d4b9b8613b491d831fb1ca935bc27eddb2b4c1bc3667e129db9582072e8a2a7aa8e58a81c9ebee70f73f9b75efe84bef6b69bc0589e617bfd916ec1cb1bdc730ae0e80f24074aefa939ba284c7126113e5f8dcb5ed0541637912b28db82e3b963225ddcd578c6230e2ecb0ff03d81062cbcca9baaa4051f04fd9ea96f552512928d033728a4ebcefb0d669a2e228d2d7e08efc8b3dc8e049852ca5c19752ff9138517a1093e54e7129ef6dcbbf51473b6ef052017e4ad922ab474e983788759d14f3404d9d3f6cd6b429f09faa4ca89645fbbab567e8be6fe86472ad30660a2617523519625c2a943905dce2fa54ba7d5adac077e85265d091f2fb5113dda65c02f80434a433011e91cd9f279425059fdac037eaa82efb978d6e72a10f180c42422d4a10637d832d0d9527780c26f713831b5dd5ef38ca093505e7913097d9d9b1cf1a8806e4ef2b315398bd6cbb9b845eb6d83e11708151027b08bdf0ce0ff352c6953461d075d887089b9470e2a3c23d74d1a02f80c15958a42a27fb9a3b0acc5657ddca7130a821bc1e8adb4bd05183692a2948d5df6f2941eb012a5e6e423adbfa5cdec96e49fdd0cf14263487b51a65a7e348ecd83d965135794dd8cdf2f520000f6061d6eb4daf46bdc7bdf27a0744ed8%5C%22%7D%22%7D%2C%22locationInfo%22%3A%7B%22latitude%22%3A%2231.226464%22%2C%22longitude%22%3A%22121.546847%22%2C%22status%22%3A%220%22%2C%22type%22%3A%22network%22%2C%22updateTime%22%3A1557222824954%7D%2C%22osType%22%3A%22android%22%2C%22osVersion%22%3A%228.0.0%22%2C%22sourcePlatForm%22%3A%22MAIN_APP%22%2C%22terminalType%22%3A%22APP%22%2C%22thirdChannel%22%3A0%2C%22tokenId%22%3A%22aoDcGxWtIoVwC1F79%2BeivWHLIf%2BhobvqY%2FsaZfFnnYVMIzCNagEAAA%3D%3D%22%7D%2C%22nickname%22%3A%22hsbs%22%2C%22passcode%22%3A%22mb7qGM8qu4yrvA8xuuuT6z2wHroGp1Pk34p1gk0slCy7gqfjSnnDlyPouUKlhtxAOLuEHFHc%2B02hHtBdEt2e3MH3Mp2i2z9etHxaJGO%2B4Kai%2BbMzmxjMQXoJWmz507Vr3oq6J8HE04SWef1TNR3eEtbE7eDQihZXNzPHRXGbLNYd5NAAQMFCAKOMdbHrv9ZN1jomrrqTLH%2F6sxqVov%2Fh0hwZjyUysvpsRH6XThzH0frCRmH4Wt9vLEeIEcvAbnqrcss1dLUnzvzhvnlEKGnPcuVLXG7UTHGQT5n48NcCHFeDqQxhN7lhI3Vzsp7KnNH8otDiyyyFw5IAuNmIUw9fPQ%3D%3D%22%2C%22phoneNumber%22%3A%2262-"+paramMap.get("phoneNumber")+"%22%2C%22referralCode%22%3A%22%22%7D%5D&ts=1557222828568";
    }

    protected String getUrl() {
        return url;
    }

    protected Map<String, String> getResponseCheck() {
        return null;
    }

    protected Headers getHeaders() {
        Map<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("Host", "msg-gw.aphome.id.sit.alipay.net");
        headerMap.put("appId", "2D005CA271131");
        headerMap.put("workspaceId", "sit");
        headerMap.put("version", "2.0");
        headerMap.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headerMap.put("Accept", "*/*");
        headerMap.put("clientId", "460011600687774|865931020177465");
        headerMap.put("Accept-Language", "en-US");
        headerMap.put("Accept-Encoding", "gzip, deflate");
        headerMap.put("OPERATION-TYPE", "alipayplus.mobilewallet.user.login");
        headerMap.put("Content-Length", "762");
        headerMap.put("did", "W/y7PYLFpD4DAIAW1vcOHgmY");
        headerMap.put("tenantId", "unset");
        headerMap.put("ts", "1544009617477");
        headerMap.put("User-Agent", "Skywalker/1 CFNetwork/975.0.3 Darwin/18.2.0");
        headerMap.put("Connection", "keep-alive");
        headerMap.put("cache-control", "no-cache");
        headerMap.put("Postman-Token", "e912247e-5138-4363-85aa-4a591a054a11");
        headerMap.put("Cookie",String.valueOf(paramMap.get("cookie")));
        return Headers.of(headerMap);
    }
}
