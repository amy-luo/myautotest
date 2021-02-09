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
public class SecurityGetPublickeyTest {
    protected static final Logger logger= LoggerFactory.getLogger(SecurityGetPublickeyTest.class);
    @CCPrepare(id="SecurityGetPublickeyTest")
    public static Map<String,Object> securityGetPublickey(Map<String,Object> paramMap){

        paramMap.put("3","3");
        return paramMap;
    }
}
