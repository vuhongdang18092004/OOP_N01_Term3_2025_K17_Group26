package com.example;

import java.time.LocalDateTime;

public class AmbulanceTrip {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String destination;
    private String notes;
    private Ambulance ambulance;
    private User driver;
    private Doctor doctor;
    private Patient patient;

    public AmbulanceTrip(Long id, String destination, String notes, Ambulance ambulance, User driver, Doctor doctor, Patient patient) {
        this.id = id;
        this.destination = destination;
        this.notes = notes;
        this.ambulance = ambulance;
        this.driver = driver;
        this.doctor = doctor;
        this.patient = patient;
    }

    public void startTrip() {
        this.startTime = LocalDateTime.now();
        System.out.println("Trip started to " + destination);
    }

    public void endTrip() {
        this.endTime = LocalDateTime.now();
        this.ambulance.updateAmbulance("Available");
        System.out.println("Trip ended for destination: " + destination);
    }
}

