package com.mytest.ptmanager;

import com.mytest.ptmanager.wrapper.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;

//TODO 接入springboot
@SpringBootApplication(scanBasePackages="com.mytest.ptmanager")
@ImportResource(locations = "classpath:consumer.xml")
public class PtManagerApplication {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    private RedisClient redisClient;

    public static void main(String[] args){
        SpringApplication.run(PtManagerApplication.class,args);
    }
}
