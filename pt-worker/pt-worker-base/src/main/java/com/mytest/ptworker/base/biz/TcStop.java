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
    public TcStopResponse tcStop(TcStopRequest request){
        ParasForTest.status=false;
        TcStopResponse response=new TcStopResponse();
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
