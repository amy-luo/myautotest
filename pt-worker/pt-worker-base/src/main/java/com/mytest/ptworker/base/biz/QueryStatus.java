package com.mytest.ptworker.base.biz;

import com.mytest.ptworker.client.model.dto.QueryStatusResponse;
import com.mytest.ptworker.client.model.request.QueryStatusRequest;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class QueryStatus {
    public QueryStatusResponse queryStatus(QueryStatusRequest request){
        QueryStatusResponse response=new QueryStatusResponse();
        try {
            String localip=InetAddress.getLocalHost().getHostAddress();
            response.setSuccess(true);
            response.setIpOfWorker(localip);
            response.setStatus(ParasForTest.status);
            System.out.println("本机的ip是 ："+localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setErrorMessage("本地ip查询失败");
        }
        return response;
    }
}
