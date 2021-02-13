package com.mytest.ptworker.client.service;

import com.mytest.ptworker.client.model.dto.WorkerStatusDTO;
import com.mytest.ptworker.client.model.request.WorkerStatusDTORequest;

public interface WorkerQueryService {

    public WorkerStatusDTO queryWorkStatus(WorkerStatusDTORequest request);
}
