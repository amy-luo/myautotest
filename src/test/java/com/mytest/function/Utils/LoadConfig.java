/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.Utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by LIMSHEN
 * Date: 20/1/5
 * Time: 21:26
 */
public class LoadConfig {
        private static ResourceBundle bundle=ResourceBundle.getBundle("ats-config", Locale.CHINA);
        public static String getConfig(String env){
            env=bundle.getString(env);
            return env;
        }
}
