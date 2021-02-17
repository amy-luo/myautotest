package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.client.model.dto.ModifyQpsResponse;
import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.request.ModifyQpsRequest;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class ModifyQps {
    @Autowired
    LoadTestNew loadTestNew;
    public ModifyQpsResponse modifyQps(ModifyQpsRequest request){
        ParasForTest.status=true;
        String tcId="";
        if(request.getTcId()!=null) {
            tcId=request.getTcId();
        }
        if(request.getCyclesCount()!=null) {
            ParasForTest.cyclesCount = request.getCyclesCount();
        }
        if(request.getThreadCount()!=null) {
            ParasForTest.threadCount=request.getThreadCount();
        }
        ModifyQpsResponse response=new ModifyQpsResponse();

        /**开启定时器，每秒，向池子里放置任务数，以及定时计算qps，rt，错误率，发送至MQ*/
        Thread t=new Thread(new Schechule());
        t.start();

        try {
            /**从池子里拿取任务，完成任务后，将池子里的任务数减1，只要池子里有任务就循环拿取任务，没任务时等待*/
            loadTestNew.runLoadTest(tcId);
        } catch (InterruptedException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorMessage("开启压测失败");
        }
        response.setSuccess(true);
        response.setStatus(ParasForTest.status);
        //查找本地ip；
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
