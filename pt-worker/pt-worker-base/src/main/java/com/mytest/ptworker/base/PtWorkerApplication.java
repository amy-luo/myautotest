package com.mytest.ptworker.base;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages="com.mytest.ptworker.base")
@PropertySource(value="dubbo.properties")
public class PtWorkerApplication {
    public static void main( String[] args ) {}
}
