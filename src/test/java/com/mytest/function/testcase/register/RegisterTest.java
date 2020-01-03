package com.mytest.function.testcase.register;

import com.mytest.function.testcase.Inface.TestLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RegisterTest {

    protected static final Logger LOGGER = LoggerFactory.getLogger(RegisterTest.class);
    @TestLogic(name="USER_REGISTER")
    public void registerTest(Map<String,Object> param){
        LOGGER.info("check phone number");
        LOGGER.info("register by phoneNumber");
//        BaseInterfaceApi login = new RegisterApi();
//        //检查手机号是否已注册
//        BaseInterfaceApi checkRegisteredUserAndSendOTP = new CheckRegisteredUserAndSendOTPApi();
////        checkRegisteredUserAndSendOTP.call().successCheck();
//        //注册，进行登录
//        login.call().successCheck();
    }
}
