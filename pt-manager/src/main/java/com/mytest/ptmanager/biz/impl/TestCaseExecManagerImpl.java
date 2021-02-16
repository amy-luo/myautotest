package com.mytest.ptmanager.biz.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mytest.ptmanager.biz.TestCaseExecManager;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
import com.mytest.ptworker.client.model.dto.ModifyQpsResponse;
import com.mytest.ptworker.client.model.dto.QueryStatusResponse;
import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.dto.TcStopResponse;
import com.mytest.ptworker.client.model.request.ModifyQpsRequest;
import com.mytest.ptworker.client.model.request.QueryStatusRequest;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import com.mytest.ptworker.client.model.request.TcStopRequest;
import com.mytest.ptworker.client.service.WorkerExecService;
import com.mytest.ptworker.client.service.WorkerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//TODO 接入spring
@Component
public class TestCaseExecManagerImpl implements TestCaseExecManager {

    @Resource(name = "workerQueryServiceImpl")
    private WorkerQueryService workerQueryService;

    @Resource(name = "workerExecServiceImpl")
    private WorkerExecService workerExecService;

    @Override
    public LoadTestDTO modifyQps(String tcId,Integer threadCount, Integer cyclesCount) {
        ModifyQpsRequest request=new ModifyQpsRequest();
        request.setTcId("");
        request.setCyclesCount(cyclesCount);
        request.setThreadCount(threadCount);
        ModifyQpsResponse response =workerExecService.modifyQps(request);
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(response.isSuccess());
        if(response.getIpOfWorker()!=null) {
            dto.setIpOfWorker(response.getIpOfWorker());
        }
        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }

    @Override
    public LoadTestDTO startLoadTest(String tcId,Integer threadCount,Integer cyclesCount) {
        TcStartRequest request=new TcStartRequest();
        request.setTcId("");
        request.setCyclesCount(cyclesCount);
        request.setThreadCount(threadCount);
        TcStartResponse response =workerExecService.tcStart(request);
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(response.isSuccess());
        if(response.getIpOfWorker()!=null) {
            dto.setIpOfWorker(response.getIpOfWorker());
        }
        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }

    @Override
    public LoadTestDTO stopLoadTest(String tcId) {
        TcStopRequest request=new TcStopRequest();
        request.setTcId("");
        TcStopResponse response =workerExecService.tcStop(request);
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(response.isSuccess());
        if(response.getIpOfWorker()!=null) {
            dto.setIpOfWorker(response.getIpOfWorker());
        }
        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }
    @Override
    public LoadTestDTO queryStatus(){
        QueryStatusRequest request=new QueryStatusRequest();
        QueryStatusResponse response =workerExecService.queryStatus(request);
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(response.isSuccess());
        if(response.getIpOfWorker()!=null) {
            dto.setIpOfWorker(response.getIpOfWorker());
        }
        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }
}
