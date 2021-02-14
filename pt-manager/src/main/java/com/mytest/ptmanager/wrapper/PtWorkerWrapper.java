package com.mytest.ptmanager.wrapper;

import com.alibaba.fastjson.JSON;
import com.mytest.ptmanager.PtManagerApplication;
import com.mytest.ptmanager.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//TODO 接入spring
@Component
public class PtWorkerWrapper {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    public String test(){
        String userinfo= JSON.toJSONString(redisUtil.get("userinfo"));
        System.out.println(userinfo);
        return userinfo;
    }
}
