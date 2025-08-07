package com.crimereport.crime_reporting_system.controller;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.Report;
import com.crimereport.crime_reporting_system.service.ReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitReport(@RequestBody ReportRequest reportDto, Authentication authentication) {
        String username = authentication.getName();
        reportService.submitReport(reportDto, username);
        return ResponseEntity.ok("Report submitted successfully");
    }

    @GetMapping("/my-reports")
    public ResponseEntity<List<Report>> getMyReports(Authentication authentication) {
        String username = authentication.getName();
        List<Report> reports = reportService.getReportsByUser(username);
        return ResponseEntity.ok(reports);
    }
}
