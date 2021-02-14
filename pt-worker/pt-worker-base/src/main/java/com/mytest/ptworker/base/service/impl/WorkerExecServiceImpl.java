package com.mytest.ptworker.base.service.impl;

import com.mytest.ptworker.client.model.dto.ModifyQpsResponse;
import com.mytest.ptworker.client.model.dto.QueryStatusResponse;
import com.mytest.ptworker.client.model.dto.TcStartResponse;
import com.mytest.ptworker.client.model.dto.TcStopResponse;
import com.mytest.ptworker.client.model.request.ModifyQpsRequest;
import com.mytest.ptworker.client.model.request.QueryStatusRequest;
import com.mytest.ptworker.client.model.request.TcStartRequest;
import com.mytest.ptworker.client.model.request.TcStopRequest;
import com.mytest.ptworker.client.service.WorkerExecService;
import org.springframework.stereotype.Service;

//服务层的服务实现
//TODO 接入RPC框架的provider注解
@Service("workerExecService")
public class WorkerExecServiceImpl implements WorkerExecService {

    @Override
    public ModifyQpsResponse modifyQps(ModifyQpsRequest request) {
        ModifyQpsResponse response = new ModifyQpsResponse();
        return response;
    }
    @Override
    public QueryStatusResponse queryStatus(QueryStatusRequest request) {
        QueryStatusResponse response = new QueryStatusResponse();
        return response;
    }
    @Override
    public TcStartResponse tcStart(TcStartRequest request) {
        TcStartResponse response = new TcStartResponse();
        return response;
    }

    @Override
    public TcStopResponse tcStop(TcStopRequest request) {
        TcStopResponse response = new TcStopResponse();
        return response;
    }
}
