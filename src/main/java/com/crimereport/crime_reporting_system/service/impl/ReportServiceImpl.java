package com.crimereport.crime_reporting_system.service.impl;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.Report;
import com.crimereport.crime_reporting_system.repository.ReportRepository;
import com.crimereport.crime_reporting_system.service.ReportService;
import com.crimereport.crime_reporting_system.util.Status;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public Report submitReport(ReportRequest request, String username) {
        Report report = new Report();
        report.setDescription(request.getDescription());
        report.setLocation(request.getLocation());
        report.setDateOfIncident(request.getDateOfIncident());
        report.setVictimType(request.getVictimType());
        report.setUsername(username);
        report.setStatus(Status.PENDING); // Make sure Status enum exists
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getReportsByUser(String username) {
        return reportRepository.findByUsername(username);
    }
}
