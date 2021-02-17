package com.mytest.ptmanager.biz;

import com.mytest.ptmanager.model.dto.LoadTestDTO;
import org.springframework.stereotype.Service;

public interface TestCaseExecManager {

    public LoadTestDTO modifyQps(String methodType,String tcId,Integer threadCount, Integer cyclesCount);

    public LoadTestDTO startLoadTest(String methodType,String tcId,Integer threadCount,Integer cyclesCount);

    public LoadTestDTO stopLoadTest(String methodType);

    public LoadTestDTO queryStatus(String methodType);
}
