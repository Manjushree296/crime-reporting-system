package com.crimereport.crime_reporting_system.repository;

import com.crimereport.crime_reporting_system.entity.CaseReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseReportRepository extends JpaRepository<CaseReport, Long> {

    List<CaseReport> findByUsername(String username);

    List<CaseReport> findByStatus(String status);
}
