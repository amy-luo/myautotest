package com.mytest.ptmanager.biz;

import org.springframework.stereotype.Service;

@Service
public interface TestCaseExecManager {

    public void modifyQps(Integer threadCount,Integer cyclesCount);

    public void startLoadTest(String tcId,Integer threadCount,Integer cyclesCount);

    public void stopLoadTest(String tcId);

    public void queryStatus(String tcId);
}
