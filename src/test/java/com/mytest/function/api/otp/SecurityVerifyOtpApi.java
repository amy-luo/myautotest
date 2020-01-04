/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.api.otp;

import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;

import java.util.Map;

/**
 * Created by LIMSHEN
 * Date: 20/1/4
 * Time: 01:00
 */
@CCHost
public class SecurityVerifyOtpApi {
    @CCPrepare(id="SecurityVerifyOtpApi")
    public static Map<String,String> securityVerifyOtp(Map<String,String> paramMap){
        paramMap.put("2","2");
        return paramMap;
    }
}
