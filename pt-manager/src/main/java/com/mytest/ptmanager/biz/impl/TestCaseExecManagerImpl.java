package com.mytest.ptmanager.biz.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.mytest.ptmanager.biz.TestCaseExecManager;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
import com.mytest.ptmanager.wrapper.ZkClient;
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

    @Autowired
    private ZkClient zkClient;

    @Override
    public LoadTestDTO modifyQps(String methodType,String tcId,Integer threadCount, Integer cyclesCount) {
        ZkParas zkParas=new ZkParas();
        zkParas.setMethodType(methodType);
        zkParas.setTcId("");
        zkParas.setCyclesCount(cyclesCount);
        zkParas.setThreadCount(threadCount);
        zkClient.modifyNodeData("/pt/qps", JSON.toJSONString(zkParas).getBytes());
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(true);
//        ModifyQpsRequest request=new ModifyQpsRequest();
//        request.setTcId("");
//        request.setCyclesCount(cyclesCount);
//        request.setThreadCount(threadCount);
//        ModifyQpsResponse response =workerExecService.modifyQps(request);
//        LoadTestDTO dto=new LoadTestDTO();
//        dto.setSuccess(response.isSuccess());
//        if(response.getIpOfWorker()!=null) {
//            dto.setIpOfWorker(response.getIpOfWorker());
//        }
//        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }

    @Override
    public LoadTestDTO startLoadTest(String methodType,String tcId,Integer threadCount,Integer cyclesCount) {
        ZkParas zkParas=new ZkParas();
        zkParas.setMethodType(methodType);
        zkParas.setTcId("");
        zkParas.setCyclesCount(cyclesCount);
        zkParas.setThreadCount(threadCount);
        zkClient.modifyNodeData("/pt/qps", JSON.toJSONString(zkParas).getBytes());
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(true);
        //        TcStartResponse response =workerExecService.tcStart(request);
//        dto.setSuccess(response.isSuccess());
//        if(response.getIpOfWorker()!=null) {
//            dto.setIpOfWorker(response.getIpOfWorker());
//        }
//        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }

    @Override
    public LoadTestDTO stopLoadTest(String methodType) {
        ZkParas zkParas=new ZkParas();
        zkParas.setMethodType(methodType);
        zkParas.setTcId("");
        zkParas.setCyclesCount(0);
        zkParas.setThreadCount(0);
        zkClient.modifyNodeData("/pt/qps", JSON.toJSONString(zkParas).getBytes());
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(true);
//        TcStopRequest request=new TcStopRequest();
//        TcStopResponse response =workerExecService.tcStop(request);
//        LoadTestDTO dto=new LoadTestDTO();
//        dto.setSuccess(response.isSuccess());
//        if(response.getIpOfWorker()!=null) {
//            dto.setIpOfWorker(response.getIpOfWorker());
//        }
//        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }
    @Override
    public LoadTestDTO queryStatus(String methodType){
        ZkParas zkParas=new ZkParas();
        zkParas.setMethodType(methodType);
        zkParas.setTcId("");
        zkParas.setCyclesCount(0);
        zkParas.setThreadCount(0);
        zkClient.modifyNodeData("/pt/qps", JSON.toJSONString(zkParas).getBytes());
        LoadTestDTO dto=new LoadTestDTO();
        dto.setSuccess(true);
//        QueryStatusRequest request=new QueryStatusRequest();
//        QueryStatusResponse response =workerExecService.queryStatus(request);
//        LoadTestDTO dto=new LoadTestDTO();
//        dto.setSuccess(response.isSuccess());
//        if(response.getIpOfWorker()!=null) {
//            dto.setIpOfWorker(response.getIpOfWorker());
//        }
//        dto.setErrorMessage(response.getErrorMessage());
        return dto;
    }
}
