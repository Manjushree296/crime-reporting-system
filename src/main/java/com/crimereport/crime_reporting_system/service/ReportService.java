package com.crimereport.crime_reporting_system.service;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.Report;

import java.util.List;

public interface ReportService {
    Report submitReport(ReportRequest request, String username);
    List<Report> getReportsByUser(String username);
}
