package com.mytest.ptmanager.biz;

import com.mytest.ptmanager.model.dto.LoadTestDTO;
import org.springframework.stereotype.Service;

public interface TestCaseExecManager {

    public LoadTestDTO modifyQps(String tcId,Integer threadCount, Integer cyclesCount);

    public LoadTestDTO startLoadTest(String tcId,Integer threadCount,Integer cyclesCount);

    public LoadTestDTO stopLoadTest(String tcId);

    public LoadTestDTO queryStatus();
}
