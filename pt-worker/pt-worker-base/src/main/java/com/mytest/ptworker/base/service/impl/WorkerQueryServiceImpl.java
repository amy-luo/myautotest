package com.mytest.ptworker.base.service.impl;

import com.mytest.ptworker.client.model.dto.WorkerStatusDTO;
import com.mytest.ptworker.client.model.request.WorkerStatusDTORequest;
import com.mytest.ptworker.client.service.WorkExecService;
import com.mytest.ptworker.client.service.WorkerQueryService;

//服务层的服务实现
//TODO 接入RPC框架的provider注解
public class WorkerQueryServiceImpl implements WorkerQueryService {

    @Override
    public WorkerStatusDTO queryWorkStatus(WorkerStatusDTORequest request) {
        WorkerStatusDTO dto=new WorkerStatusDTO();
        return dto;
    }
}
