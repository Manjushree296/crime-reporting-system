package com.crimereport.crime_reporting_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CaseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String officerUsername;

    private String victim;

    private String location;

    private LocalDate dateOfIncident;

    private String description;

    private String status; // Should match enum values like "PENDING", "ASSIGNED", etc.

    private String remarks;
}
