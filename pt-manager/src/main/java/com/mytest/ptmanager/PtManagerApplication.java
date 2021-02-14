package com.mytest.ptmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

//TODO 接入springboot
@SpringBootApplication(scanBasePackages="com.mytest.ptmanager")
@ImportResource(locations = "classpath:consumer.xml")
public class PtManagerApplication {
    public static void main(String[] args){
        SpringApplication.run(PtManagerApplication.class,args);
    }
}
