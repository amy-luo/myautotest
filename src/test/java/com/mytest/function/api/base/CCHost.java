/*
* Copyright (c) 2016 xiaoyouzi.com. All Rights Reserved.
*/
package com.mytest.function.api.base;

import java.lang.annotation.*;

/**
 * Created by LIMSHEN
 * Date: 20/1/4
 * Time: 01:08
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CCHost {
    String value() default "";
}
