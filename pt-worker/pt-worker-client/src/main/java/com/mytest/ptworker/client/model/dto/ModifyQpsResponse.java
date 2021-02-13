package com.mytest.ptworker.client.model.dto;

public class ModifyQpsResponse {
    private Integer tcId;

    private boolean success;

    private String errorMessage;

    private boolean status;

    private String ipOfWorker;


    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIpOfWorker() {
        return ipOfWorker;
    }

    public void setIpOfWorker(String ipOfWorker) {
        this.ipOfWorker = ipOfWorker;
    }



}
