package com.crimereport.crime_reporting_system.controller;

import com.crimereport.crime_reporting_system.dto.LoginRequest;
import com.crimereport.crime_reporting_system.dto.LoginResponse;
import com.crimereport.crime_reporting_system.dto.UserRequest;
import com.crimereport.crime_reporting_system.entity.User;
import com.crimereport.crime_reporting_system.repository.UserRepository;
import com.crimereport.crime_reporting_system.security.JwtUtil;
import com.crimereport.crime_reporting_system.util.ApiStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOpt.get();

        return ResponseEntity.ok(
                new LoginResponse(
                        ApiStatus.SUCCESS,
                        "Login successful",
                        token,
                        user.getRole().name() // CITIZEN or OFFICER
                )
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findByUsername(userRequest.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        newUser.setName(userRequest.getName());
        newUser.setPhone(userRequest.getPhone());
        newUser.setLocation(userRequest.getLocation());
        newUser.setRole(userRequest.getRole());

        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
