package com.crimereport.crime_reporting_system.controller;

import com.crimereport.crime_reporting_system.dto.ReportRequest;
import com.crimereport.crime_reporting_system.entity.CaseReport;
import com.crimereport.crime_reporting_system.service.CaseService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    // ✅ Citizen submits a new report
    @PostMapping("/submit")
    public CaseReport submit(@RequestBody ReportRequest request, Authentication auth) {
        return caseService.submitReport(request, auth.getName());
    }

    // ✅ Citizen views their submitted reports
    @GetMapping("/citizen")
    public List<CaseReport> getCitizenReports(Authentication auth) {
        return caseService.getCitizenReports(auth.getName());
    }

    // ✅ Officer views unassigned reports
    @GetMapping("/unassigned")
    public List<CaseReport> getUnassigned() {
        return caseService.getUnassignedReports();
    }

    // ✅ Officer assigns themselves to a case
    @PostMapping("/assign/{id}")
    public CaseReport assign(@PathVariable Long id, Authentication auth) {
        return caseService.assignCase(id, auth.getName());
    }

    // ✅ Officer rejects a case with a reason
    @PostMapping("/reject/{id}")
    public CaseReport reject(@PathVariable Long id, @RequestBody String reason) {
        return caseService.rejectCase(id, reason);
    }
}
