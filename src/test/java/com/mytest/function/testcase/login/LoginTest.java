package com.mytest.function.testcase.login;

import com.mytest.function.testcase.Inface.TestLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Map;

public class LoginTest {

    protected static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);

    @TestLogic(name = "USER_LOGIN")
    public void loginTest(Map<String,String> paramMap){
        LOGGER.info("check phone number");
        LOGGER.info("register by phoneNumber");
        Assert.assertEquals(0,1);
//        LoginApi loginApi = new LoginApi();
//         //检查手机号是否已注册
//        BaseInterfaceApi checkRegisteredUserAndSendOTP = new CheckRegisteredUserAndSendOTPApi();
//        checkRegisteredUserAndSendOTP.call().successCheck();
//        loginApi.login(paramMap);
    }
}
