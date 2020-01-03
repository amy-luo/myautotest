package com.mytest.function.api.base;

import java.lang.annotation.*;

/**
 * @author LIMSHEN
 * @date 2020/1/3 21:40
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CCPrepare {
    String id();
    String description() default "";
}
