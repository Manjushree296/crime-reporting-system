package com.crimereport.crime_reporting_system.service.impl;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.CaseReport;
import com.crimereport.crime_reporting_system.repository.CaseReportRepository;
import com.crimereport.crime_reporting_system.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseReportRepository caseReportRepository;

    @Override
    public CaseReport submitReport(ReportRequest request, String username) {
        CaseReport report = new CaseReport();
        report.setUsername(username);
        report.setDescription(request.getDescription());
        report.setDateOfIncident(request.getDateOfIncident());
        report.setLocation(request.getLocation());
        report.setVictim(request.getVictimType()); // ✅ Corrected method call
        report.setStatus("PENDING");
        return caseReportRepository.save(report);
    }

    @Override
    public List<CaseReport> getCitizenReports(String username) {
        return caseReportRepository.findByUsername(username);
    }

    @Override
    public List<CaseReport> getUnassignedReports() {
        return caseReportRepository.findByStatus("PENDING");
    }

    @Override
    public CaseReport assignCase(Long id, String officerUsername) {
        CaseReport report = caseReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found with ID: " + id));
        report.setStatus("ASSIGNED");
        report.setOfficerUsername(officerUsername);
        return caseReportRepository.save(report);
    }

    @Override
    public CaseReport rejectCase(Long id, String reason) {
        CaseReport report = caseReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found with ID: " + id));
        report.setStatus("REJECTED");
        report.setRemarks(reason);
        return caseReportRepository.save(report);
    }
}
