package com.crimereport.crime_reporting_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CrimeReportingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimeReportingSystemApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		System.out.println("✅ Crime Reporting System is running...");
	}
}
