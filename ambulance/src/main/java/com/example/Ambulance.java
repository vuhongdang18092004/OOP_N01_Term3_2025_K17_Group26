package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ambulance {
    private Long id;
    private String licensePlate;
    private String type;
    private String status;
    private int capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<AmbulanceTrip> trips = new ArrayList<>();

    public Ambulance(Long id, String licensePlate, String type, int capacity) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.status = "Available";
        this.capacity = capacity;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void addAmbulance() {
        System.out.println("Ambulance added: " + this.licensePlate);
    }

    public void updateAmbulance(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
        System.out.println("Ambulance updated to status: " + status);
    }

    public void deleteAmbulance() {
        System.out.println("Ambulance deleted: " + this.licensePlate);
    }

    public void assignTrip(AmbulanceTrip trip) {
        trips.add(trip);
        this.status = "On Trip";
        this.updatedAt = LocalDateTime.now();
        System.out.println("Trip assigned to ambulance " + this.licensePlate);
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
