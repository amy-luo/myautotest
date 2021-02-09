package com.mytest.ptworker.client.service;

import com.mytest.ptworker.client.model.request.TcStartRequest;

//Service服务定义
public interface WorkExecService {

    public void startLoadTest(TcStartRequest request);
}
