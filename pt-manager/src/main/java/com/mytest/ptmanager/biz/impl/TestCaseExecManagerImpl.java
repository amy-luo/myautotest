package com.mytest.ptmanager.biz.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mytest.ptmanager.biz.TestCaseExecManager;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
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
    public LoadTestDTO modifyQps(Integer threadCount, Integer cyclesCount) {
        LoadTestDTO dto=new LoadTestDTO();
        return dto;
    }

    @Override
    public LoadTestDTO startLoadTest(String tcId,Integer threadCount,Integer cyclesCount) {
        LoadTestDTO dto=new LoadTestDTO();
        return dto;
    }

    @Override
    public LoadTestDTO stopLoadTest(String tcId) {
        LoadTestDTO dto=new LoadTestDTO();
        return dto;
    }
    @Override
    public LoadTestDTO queryStatus(String tcId){
        LoadTestDTO dto=new LoadTestDTO();
        return dto;
    }
}
