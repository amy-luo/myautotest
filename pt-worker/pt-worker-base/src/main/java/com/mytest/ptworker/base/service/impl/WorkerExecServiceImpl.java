package com.mytest.ptworker.base.service.impl;

import com.mytest.ptworker.base.biz.ModifyQps;
import com.mytest.ptworker.base.biz.QueryStatus;
import com.mytest.ptworker.base.biz.TcStart;
import com.mytest.ptworker.base.biz.TcStop;
import com.mytest.ptworker.client.model.dto.ModifyQpsResponse;
import com.mytest.ptworker.client.model.dto.QueryStatusResponse;
import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.dto.TcStopResponse;
import com.mytest.ptworker.client.model.request.ModifyQpsRequest;
import com.mytest.ptworker.client.model.request.QueryStatusRequest;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import com.mytest.ptworker.client.model.request.TcStopRequest;
import com.mytest.ptworker.client.service.WorkerExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//服务层的服务实现
//TODO 接入RPC框架的provider注解
@Service("workerExecService")
public class WorkerExecServiceImpl implements WorkerExecService {
    @Autowired
    ModifyQps modifyQps;

    @Autowired
    QueryStatus queryStatus;

    @Autowired
    TcStart tcStart;

    @Autowired
    TcStop tcStop;

    @Override
    public ModifyQpsResponse modifyQps(ModifyQpsRequest request) {
        ModifyQpsResponse response =modifyQps.modifyQps(request);
        return response;
    }
    @Override
    public QueryStatusResponse queryStatus(QueryStatusRequest request) {
        QueryStatusResponse response = queryStatus.queryStatus(request);
        return response;
    }
    @Override
    public TcStartResponse tcStart(TcStartRequest request) {
        TcStartResponse response = tcStart.tcStart(request);
        return response;
    }

    @Override
    public TcStopResponse tcStop(TcStopRequest request) {
        TcStopResponse response = tcStop.tcStop(request);
        return response;
    }
}
