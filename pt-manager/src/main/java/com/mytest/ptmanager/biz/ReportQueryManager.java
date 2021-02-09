package com.mytest.ptmanager.biz;

import com.mytest.ptmanager.model.dto.TestReportDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReportQueryManager {

    public TestReportDTO queryTestReport(String tcId);
}
