package com.mytest.ptmanager;

import com.mytest.ptmanager.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

//TODO 接入springboot
@SpringBootApplication(scanBasePackages="com.mytest.ptmanager")
@ImportResource(locations = "classpath:consumer.xml")
public class PtManagerApplication {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    public static void main(String[] args){
        SpringApplication.run(PtManagerApplication.class,args);
    }
}
