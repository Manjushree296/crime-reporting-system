package com.crimereport.crime_reporting_system.dto;

import com.crimereport.crime_reporting_system.util.ApiStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private ApiStatus status;
    private String message;
    private String token;
    private String role;
}
