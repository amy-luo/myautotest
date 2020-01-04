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
 * Time: 01:01
 */
@CCHost
public class SkyRegisterRegisterApi {
    @CCPrepare(id="SkyRegisterRegisterApi")
    public static Map<String,String> skyRegisterRegister(Map<String,String> paramMap){
        paramMap.put("4","4");
        return paramMap;
    }
}
