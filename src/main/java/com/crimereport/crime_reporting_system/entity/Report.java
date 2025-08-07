package com.crimereport.crime_reporting_system.entity;

import com.crimereport.crime_reporting_system.util.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String location;

    private LocalDate dateOfIncident;

    private String victimType; // like "SELF" or "OTHER"

    private String username; // citizen's username

    @Enumerated(EnumType.STRING)
    private Status status;
}
