/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.api.otp;

import com.mytest.function.api.base.CCHost;
import com.mytest.function.api.base.CCPrepare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by LIMSHEN
 * Date: 20/1/4
 * Time: 01:01
 */
@CCHost
public class SecurityGetPublickeyApi {
    Logger logger= LoggerFactory.getLogger(SecurityGetPublickeyApi.class);
    @CCPrepare(id="SecurityGetPublickeyApi")
    public static Map<String,String> securityGetPublickey(Map<String,String> paramMap){

        paramMap.put("3","3");
        return paramMap;
    }
}
