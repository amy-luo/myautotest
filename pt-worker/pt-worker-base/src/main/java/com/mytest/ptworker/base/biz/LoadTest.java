package com.mytest.ptworker.base.biz;

import com.alibaba.fastjson.JSON;
import com.mytest.ptworker.base.testcase.ReportPacketTest;
import com.mytest.ptworker.base.wrapper.RocketMqProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Component
public class LoadTest extends Thread{
    @Autowired
    RocketMqProducer rocketMqProducer;

    protected static final Logger logger= LoggerFactory.getLogger(LoadTest.class);
    public void runLoadTest(Integer threadCount,Integer cyclesCount,String tcId) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Callable<Long>> tasks = new ArrayList<>();
        final ReportPacketTest test=new ReportPacketTest();
        ReportPacketTest.error=0;
        for (int i = 0; i < cyclesCount; i++) {
            if(ParasForTest.status) {
                Callable<Long> task = new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        long startTime = System.currentTimeMillis();
                        int error = 0;
                        error = test.reportPacketLoad(error);
                        ReportPacketTest.error=ReportPacketTest.error+error;
                        return System.currentTimeMillis() - startTime;
                    }
                };
                tasks.add(task);
            }
            else if(!ParasForTest.status){
                break;
            }
        }
        long st =System.currentTimeMillis();
        logger.info("开始时间"+st);
        List<Future<Long>> resultList=executorService.invokeAll(tasks);
        long et =System.currentTimeMillis();
        logger.info("结束时间"+et);
        List<Long> rtList=new ArrayList<>();
        resultList.forEach(result->{
            try{
                rtList.add(result.get());
            }catch (Throwable t){
                throw new RuntimeException(t);
            }
        });
        double rt=rtList.stream().mapToLong(o->o).average().orElse(0)/1000;
        double qps=(double)cyclesCount/rt;
        double errorPercent=ReportPacketTest.error/cyclesCount;
        ReportMessage reportMessage=new ReportMessage();
        reportMessage.setSt(st);
        reportMessage.setEt(et);
        reportMessage.setQps(qps);
        reportMessage.setRt(rt);
        reportMessage.setCyclesCount(cyclesCount);
        reportMessage.setThreadCount(threadCount);
        reportMessage.setErrorPercent(errorPercent);
        rocketMqProducer.sendMsg("WORKER_TC_RUN_REPORT",reportMessage);
        logger.info(JSON.parseObject(JSON.toJSONString(reportMessage.toString())).toJSONString());
    }
}
