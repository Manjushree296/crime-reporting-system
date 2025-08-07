package com.crimereport.crime_reporting_system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportRequest {
    private String description;
    private String location;
    private LocalDate dateOfIncident;
    private String victimType;
}
