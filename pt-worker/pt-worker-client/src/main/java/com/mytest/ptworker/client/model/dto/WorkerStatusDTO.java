package com.mytest.ptworker.client.model.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WorkerStatusDTO implements Serializable {

    private String workerId;

    private String status;

    private Integer runningTc;

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRunningTc() {
        return runningTc;
    }

    public void setRunningTc(Integer runningTc) {
        this.runningTc = runningTc;
    }
}
