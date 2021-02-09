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
public class SkyRegisterRegisterTest {
    protected static final Logger logger= LoggerFactory.getLogger(SkyRegisterRegisterTest.class);
    @CCPrepare(id="SkyRegisterRegisterTest")
    public static Map<String,Object> skyRegisterRegister(Map<String,Object> paramMap){
//        String env=
        paramMap.put("4","4");
        return paramMap;
    }
}
