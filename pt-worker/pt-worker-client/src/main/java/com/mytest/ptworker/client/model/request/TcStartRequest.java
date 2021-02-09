package com.mytest.ptworker.client.model.request;

import org.springframework.stereotype.Component;

import java.io.Serializable;

//定义了rpc服务的请求参数结构
@Component
public class TcStartRequest implements Serializable {

    private String tcId;

    private Integer qps;

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public Integer getQps() {
        return qps;
    }

    public void setQps(Integer qps) {
        this.qps = qps;
    }
}
