package com.mytest.ptmanager.wrapper;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//TODO 接入spring
@Component
public class PtWorkerWrapper {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisClient redisClient;

    public String test(){
        String userinfo= JSON.toJSONString(redisClient.get("userinfo"));
        System.out.println(userinfo);
        return userinfo;
    }
}
