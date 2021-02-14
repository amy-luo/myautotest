package com.mytest.ptworker.base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages="com.mytest.ptworker.base")
@ImportResource(locations = "classpath:provider.xml")
public class PtWorkerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(PtWorkerApplication.class, args);
    }
}
