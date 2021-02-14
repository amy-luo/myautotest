package com.mytest.ptworker.client.service;

import com.mytest.ptworker.client.model.dto.*;
import com.mytest.ptworker.client.model.request.*;


public interface WorkerExecService {
    public ModifyQpsResponse modifyQps(ModifyQpsRequest request);
    public QueryStatusResponse queryStatus(QueryStatusRequest request);
    public TcStartResponse tcStart(TcStartRequest request);
    public TcStopResponse tcStop(TcStopRequest request);
}
