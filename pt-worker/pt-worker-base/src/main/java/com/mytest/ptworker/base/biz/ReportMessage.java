package com.mytest.ptworker.base.biz;

public class ReportMessage {
    private Long st;
    private Long et;
    private double qps;
    private double rt;
    private Integer cyclesCount;
    private Integer threadCount;
    private double errorPercent;

    public Long getSt() {
        return st;
    }

    public void setSt(Long st) {
        this.st = st;
    }

    public Long getEt() {
        return et;
    }

    public void setEt(Long et) {
        this.et = et;
    }

    public double getQps() {
        return qps;
    }

    public void setQps(double qps) {
        this.qps = qps;
    }

    public double getRt() {
        return rt;
    }

    public void setRt(double rt) {
        this.rt = rt;
    }

    public Integer getCyclesCount() {
        return cyclesCount;
    }

    public void setCyclesCount(Integer cyclesCount) {
        this.cyclesCount = cyclesCount;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public double getErrorPercent() {
        return errorPercent;
    }

    public void setErrorPercent(double errorPercent) {
        this.errorPercent = errorPercent;
    }
}
