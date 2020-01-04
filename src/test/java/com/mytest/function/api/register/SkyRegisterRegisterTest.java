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
 * Time: 01:01
 */
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
