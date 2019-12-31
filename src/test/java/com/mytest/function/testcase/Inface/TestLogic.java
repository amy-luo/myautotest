package com.mytest.function.testcase.Inface;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestLogic {
    String name();
}
