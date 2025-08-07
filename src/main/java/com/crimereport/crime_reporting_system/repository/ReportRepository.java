package com.crimereport.crime_reporting_system.repository;

import com.crimereport.crime_reporting_system.entity.Report;
import com.crimereport.crime_reporting_system.util.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByUsername(String username);  // ✅ Added for fixing error
    List<Report> findByStatus(Status status);
}
