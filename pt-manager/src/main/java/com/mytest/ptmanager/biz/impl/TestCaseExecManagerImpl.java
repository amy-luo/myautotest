package com.mytest.ptmanager.biz.impl;

import com.mytest.ptmanager.biz.TestCaseExecManager;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
import com.mytest.ptworker.client.service.WorkerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//TODO 接入spring
@Component
public class TestCaseExecManagerImpl implements TestCaseExecManager {

//    @Qualifier("workerQueryService")
//    @Resource(name = "workerQueryService")
    @Autowired
    private WorkerQueryService workerQueryService;

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

    };
}
