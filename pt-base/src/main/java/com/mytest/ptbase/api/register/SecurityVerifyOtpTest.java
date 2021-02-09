/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.ptbase.api.register;

import com.mytest.ptbase.api.base.CCHost;
import com.mytest.ptbase.api.base.CCPrepare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@CCHost
public class SecurityVerifyOtpTest {
    protected static final Logger logger= LoggerFactory.getLogger(SecurityVerifyOtpTest.class);
    @CCPrepare(id="SecurityVerifyOtpTest")
    public static Map<String,Object> securityVerifyOtp(Map<String,Object> paramMap){
        paramMap.put("2","2");
        return paramMap;
    }
}
