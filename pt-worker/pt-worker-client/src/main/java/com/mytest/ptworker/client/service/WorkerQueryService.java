package com.mytest.ptworker.client.service;

import com.mytest.ptworker.client.model.dto.WorkerStatusDTO;
import com.mytest.ptworker.client.model.request.WorkerStatusDTORequest;

//Service服务定义

public interface WorkerQueryService {

    public WorkerStatusDTO queryWorkStatus(WorkerStatusDTORequest request);
}
