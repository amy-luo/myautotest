package com.mytest.ptmanager.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytest.ptmanager.util.RedisUtil;
import com.mytest.ptworker.client.model.msg.ReportMsg;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RocketMQMessageListener(topic = "WORKER_TC_RUN_REPORT", selectorExpression = "*", consumerGroup = "PT_MANAGER")
public class TestResultConsumer implements RocketMQListener<MessageExt> {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        JSONObject jsonResult =JSON.parseObject(JSON.toJSONString(body));
        redisUtil.set(String.valueOf(messageExt.getStoreTimestamp()),jsonResult);
//        String msg = new String(body);
        System.out.println("监听到消息：msg= " + jsonResult.toJSONString());
    }
}

