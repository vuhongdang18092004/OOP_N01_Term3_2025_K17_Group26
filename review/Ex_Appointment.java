package com.project.HospitalManager;

import java.time.LocalDateTime;

public class Appointment implements Entity {
    private int appointmentId;
    private String fullName; // Changed to match interface
    private LocalDateTime appointmentTime;
    private String status;
    private Doctor doctor;
    private Patient patient;

    public Appointment(int appointmentId, String fullName, LocalDateTime appointmentTime, String status, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.fullName = fullName; // Using fullName as a placeholder name for the appointment
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public int getId() {
        return appointmentId;
    }

    @Override
    public void setId(int id) {
        this.appointmentId = id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public byte[] toBinary() {
        try {
            return this.toString().getBytes();
        } catch (Exception e) {
            System.err.println("Error converting to binary: " + e.getMessage());
            return new byte[0];
        }
    }

    // Getters and Setters
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Appointment management methods
    public void schedule() {
        try {
            this.status = "Scheduled";
        } catch (Exception e) {
            System.err.println("Error scheduling appointment: " + e.getMessage());
        }
    }

    public void cancel() {
        try {
            this.status = "Cancelled";
            if (doctor != null) doctor.removeAppointment(this);
            if (patient != null) patient.cancelAppointment(this);
        } catch (Exception e) {
            System.err.println("Error cancelling appointment: " + e.getMessage());
        }
    }

    public void complete() {
        try {
            this.status = "Completed";
        } catch (Exception e) {
            System.err.println("Error completing appointment: " + e.getMessage());
        }
    }

    public void updateStatus(String newStatus) {
        try {
            this.status = newStatus;
        } catch (Exception e) {
            System.err.println("Error updating appointment status: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID: " + appointmentId + ", Full Name: " + fullName + ", Appointment Time: " + appointmentTime +
               ", Status: " + status + ", Doctor: " + (doctor != null ? doctor.getFullName() : "None") +
               ", Patient: " + (patient != null ? patient.getFullName() : "None");
    }
}
