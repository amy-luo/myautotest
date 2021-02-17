package com.mytest.ptmanager.biz.impl;

import org.springframework.stereotype.Component;

@Component
public class ZkParas {
    public String methodType;
    public String tcId;
    public Integer threadCount;
    public Integer cyclesCount;

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Integer getCyclesCount() {
        return cyclesCount;
    }

    public void setCyclesCount(Integer cyclesCount) {
        this.cyclesCount = cyclesCount;
    }

}

