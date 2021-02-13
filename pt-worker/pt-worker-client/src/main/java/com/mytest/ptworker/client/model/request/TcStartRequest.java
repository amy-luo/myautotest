package com.mytest.ptworker.client.model.request;

import org.springframework.stereotype.Component;

import java.io.Serializable;

//定义了rpc服务的请求参数结构
@Component
public class TcStartRequest implements Serializable {

    private String tcId;
    private Integer threadCount;
    private Integer cyclesCount;

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
