package com.crimereport.crime_reporting_system.entity;

import com.crimereport.crime_reporting_system.util.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String location;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
