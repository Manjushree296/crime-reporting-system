package com.crimereport.crime_reporting_system.service;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.CaseReport;

import java.util.List;

public interface CaseService {
    CaseReport submitReport(ReportRequest request, String username);
    List<CaseReport> getCitizenReports(String username);
    List<CaseReport> getUnassignedReports();
    CaseReport assignCase(Long id, String officerUsername);
    CaseReport rejectCase(Long id, String reason);
}
