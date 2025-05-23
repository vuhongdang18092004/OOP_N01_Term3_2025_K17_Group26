package com.example;

import java.time.LocalDate;

public class Patient {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String medicalCondition;

    public Patient(Long id, String name, LocalDate dateOfBirth, String medicalCondition) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.medicalCondition = medicalCondition;
    }
}

