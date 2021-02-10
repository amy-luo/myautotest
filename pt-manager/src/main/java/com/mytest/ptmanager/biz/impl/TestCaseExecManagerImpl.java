package com.mytest.ptmanager.biz.impl;

import com.mytest.ptmanager.biz.TestCaseExecManager;
import com.mytest.ptmanager.model.dto.LoadTestDTO;
import org.springframework.stereotype.Service;

//TODO 接入spring
@Service
public class TestCaseExecManagerImpl implements TestCaseExecManager {

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
