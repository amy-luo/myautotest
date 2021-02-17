package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.base.testcase.ReportPacketTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            if (poolCount!=0) {
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
