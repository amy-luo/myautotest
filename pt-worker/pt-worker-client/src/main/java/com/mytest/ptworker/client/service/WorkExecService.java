package com.mytest.ptworker.client.service;

import com.mytest.ptworker.client.model.dto.*;
import com.mytest.ptworker.client.model.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Service服务定义
@Service
public interface WorkExecService {
    public ModifyQpsResponse modifyQps(ModifyQpsRequest request);
    public QueryStatusResponse queryStatus(QueryStatusRequest request);
    public TcStartResponse tcStart(TcStartRequest request);
    public TcStopResponse tcStop(TcStopRequest request);
}
