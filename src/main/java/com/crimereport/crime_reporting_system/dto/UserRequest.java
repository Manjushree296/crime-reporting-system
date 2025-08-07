package com.crimereport.crime_reporting_system.dto;

import com.crimereport.crime_reporting_system.util.UserRole;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String location;
    private UserRole role;
}
