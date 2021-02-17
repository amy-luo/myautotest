package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.dto.TcStopResponse;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import com.mytest.ptworker.client.model.request.TcStopRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class TcStop {
    @Autowired
    LoadTest loadTest;
    public TcStopResponse tcStop(){
        /**将参数状态改为false，线程将当前正在执行的任务完成后停止压测，不再循环取拿取任务*/
        ParasForTest.status=false;
        /**将压测状态恢复到初始值，以准备下次的压测*/
        LoadTestNew.count = 0;
        LoadTestNew.startCount = 0;
        LoadTestNew.requestCount = 0;
        LoadTestNew.errorCount = 0;
        LoadTestNew.errorPercent = 0;
        LoadTestNew.poolCount=0;
        LoadTestNew.resultList.clear();
        TcStopResponse response=new TcStopResponse();
        response.setSuccess(true);
        response.setStatus(ParasForTest.status);

        /**查找本地ip；*/
        try {
            String localip=InetAddress.getLocalHost().getHostAddress();
            response.setIpOfWorker(localip);
            System.out.println("本机的ip是 ："+localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            response.setErrorMessage("本地ip查询失败");
        }
        return response;
    }
}
