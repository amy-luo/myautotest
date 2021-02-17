package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.base.testcase.ReportPacketTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**根据入参cyclesCount，即预设QPS，每秒释放出“预设QPS”这么大数值的请求数量，实际执行出来的QPS会与预设QPS有差异。
 * 只要压测开启状态为true，池子里还有请求数量，就循环执行压测，
 * 若池子里请求数量为空，则等待，直到当下一秒当定时器往池子里释放新的请求数量
 * 定时器计算的是实际每一秒的QPS，会与预设QPS有所出入，可手动调整预设QPS值*/
@Component
public class LoadTestNew extends Thread {
    public static int count = 0;
    public static int startCount = 0;
    public static int requestCount = 0;
    public static int errorCount = 0;
    public static double errorPercent = 0;
    public static int poolCount=0;
    public static List<Long> resultList = new ArrayList<>();

    protected static final Logger logger = LoggerFactory.getLogger(LoadTest.class);

    public void runLoadTest(String tcId) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(ParasForTest.threadCount);
        final ReportPacketTest test = new ReportPacketTest();
        ReportPacketTest.error = 0;
        while (ParasForTest.status) {
            if (poolCount>0) {
                Callable<Long> task = new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        long startTime = System.currentTimeMillis();
                        int error = 0;
                        error = test.reportPacketLoad(error);
                        poolCount--;
                        ReportPacketTest.error = ReportPacketTest.error + error;
                        errorCount = errorCount + error;
                        if (error == 0) {
                            requestCount++;
                        }
                        long simpleRt=System.currentTimeMillis() - startTime;
                        resultList.add(simpleRt);
                        return simpleRt;
                    }
                };
                executorService.submit(task);
            }
        }
    }
}
