package com.mytest.ptmanager.biz;

import org.springframework.stereotype.Service;

@Service
public interface TestCaseExecManager {

    public void modifyQps(Integer qps);

    public void startLoadTest(String tcId, Integer qps);

    public void stopLoadTest(String tcId);
}
