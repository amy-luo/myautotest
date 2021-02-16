package com.mytest.ptworker.base.wrapper;

import com.mytest.ptworker.base.biz.ReportMessage;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送同步消息（sendResult为返回的发送结果）
     */
    public Boolean sendMsg(String topic, ReportMessage msgBody) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
        return null != sendResult && SendStatus.SEND_OK == sendResult.getSendStatus();
    }

    /**
     * 发送异步消息（适合对响应时间敏感的业务场景）
     */
    public void sendAsyncMsg(String topic, ReportMessage msgBody) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 处理消息发送成功逻辑
            }

            @Override
            public void onException(Throwable throwable) {
                // 处理消息发送异常逻辑
            }
        });
    }

    /**
     * 发送延时消息<br/>
     * 在start版本中 延时消息一共分为18个等级分别为：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     */
    public Boolean sendDelayMsg(String topic, ReportMessage msgBody, Integer messageTimeOut, int delayLevel) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build(), messageTimeOut, delayLevel);
        return null != sendResult && SendStatus.SEND_OK == sendResult.getSendStatus();
    }

    /**
     * 发送单向消息（不关心发送结果，如日志）
     */
    public void sendOneWayMsg(String topic, ReportMessage msgBody) {
        rocketMQTemplate.sendOneWay(topic, MessageBuilder.withPayload(msgBody).build());
    }

    /**
     * 发送带tag的消息
     */
    public Boolean sendTagMsg(String topic, String tag, ReportMessage msgBody) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic + ":" + tag, MessageBuilder.withPayload(msgBody).build());
        return null != sendResult && SendStatus.SEND_OK == sendResult.getSendStatus();
    }
}
