package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.client.model.dto.QueryStatusResponse;
import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class TcStart {
    @Autowired
    LoadTest loadTest;
    public TcStartResponse tcStart(TcStartRequest request){
        ParasForTest.status=true;
        String tcId="";
        Integer cyclesCount=0;
        Integer threadCount=10;
        if(request.getTcId()!=null) {
            tcId=request.getTcId();
        }
        if(request.getCyclesCount()!=null) {
            cyclesCount = request.getCyclesCount();
        }
        if(request.getThreadCount()!=null) {
            threadCount=request.getThreadCount();
        }
        TcStartResponse response=new TcStartResponse();
        try {
            loadTest.runLoadTest(cyclesCount,threadCount,tcId);
        } catch (InterruptedException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorMessage("开启压测失败");
        }
        response.setSuccess(true);
        response.setStatus(ParasForTest.status);
        //查找本地ip；
        try {
//            String localname=ia.getHostName();
            String localip=InetAddress.getLocalHost().getHostAddress();
            response.setIpOfWorker(localip);
//            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            response.setErrorMessage("本地ip查询失败");
        }
        return response;
    }

}
