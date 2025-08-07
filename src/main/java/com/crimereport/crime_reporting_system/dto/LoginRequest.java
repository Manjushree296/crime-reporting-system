package com.crimereport.crime_reporting_system.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
