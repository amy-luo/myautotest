/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.api.register;

import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by LIMSHEN
 * Date: 20/1/4
 * Time: 01:00
 */
@CCHost
public class SecurityVerifyOtpTest {
    protected static final Logger logger= LoggerFactory.getLogger(SecurityVerifyOtpTest.class);
    @CCPrepare(id="SecurityVerifyOtpTest")
    public static Map<String,Object> securityVerifyOtp(Map<String,Object> paramMap){
        paramMap.put("2","2");
        return paramMap;
    }
}
