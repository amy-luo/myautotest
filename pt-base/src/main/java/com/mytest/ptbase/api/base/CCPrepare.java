package com.mytest.ptbase.api.base;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CCPrepare {
    String id();
    String description() default "";
}
