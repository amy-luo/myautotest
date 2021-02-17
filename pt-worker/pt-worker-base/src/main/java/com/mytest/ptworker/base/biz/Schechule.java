package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.base.wrapper.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**定时计算qps，rt,错误率，从启动时间开始，每秒计算一次，启动时间从zk同步过来增加3s.*/

@Component
public class Schechule implements Runnable {
    @Autowired
    RocketMqProducer rocketMqProducer;

    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            ReportMessage reportMessage = new ReportMessage();
            @Override
            public void run() {
                try {
                    long st=ParasForTest.st+LoadTestNew.count*1000;
                    LoadTestNew.count++;
                    LoadTestNew.poolCount=LoadTestNew.poolCount+ParasForTest.cyclesCount;

                    /**计算一秒内的qps*/
                    int qps=LoadTestNew.requestCount-LoadTestNew.startCount;

                    /**将当前的请求数设置成下一秒的起始请求数*/
                    LoadTestNew.startCount=LoadTestNew.requestCount;

                    /**计算一秒内的平均响应时间rt*/
                    double rt = LoadTestNew.resultList.stream().mapToLong(o -> o).average().orElse(0) / 1000;

                    /**清空上一秒存储的rt；*/
                    LoadTestNew.resultList.clear();

                    /**计算错误率*/
                    LoadTestNew.errorPercent=LoadTestNew.errorCount/(LoadTestNew.requestCount+LoadTestNew.errorCount);

                    /**将st，qps，rt，错误率加入MQ*/
                    reportMessage.setSt(st);
                    reportMessage.setQps(qps);
                    reportMessage.setRt(rt);
                    reportMessage.setErrorPercent(LoadTestNew.errorPercent);
                    reportMessage.setCyclesCount(ParasForTest.cyclesCount);
                    reportMessage.setThreadCount(ParasForTest.threadCount);
                    rocketMqProducer.sendMsg("WORKER_TC_RUN_REPORT", reportMessage);
//                        logger.info(JSON.parseObject(JSON.toJSONString(reportMessage.toString())).toJSONString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Date(ParasForTest.st),1000L);
    }
}
