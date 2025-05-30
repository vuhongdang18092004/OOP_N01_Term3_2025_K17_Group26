package com.project.HospitalManager;

import java.util.ArrayList;
import java.util.List;

public class Patient implements Entity {
    private int patientId;
    private String fullName;
    private String phone;
    private String address;
    private String gender;
    private String dob;
    private String insuranceNumber;
    private List<Appointment> appointments;

    public Patient(int patientId, String fullName, String phone, String address, String gender, String dob, String insuranceNumber) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.insuranceNumber = insuranceNumber;
        this.appointments = new ArrayList<>();
    }

    @Override
    public int getId() {
        return patientId;
    }

    @Override
    public void setId(int id) {
        this.patientId = id;
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
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    // Appointment management methods
    public void addAppointment(Appointment appointment) {
        try {
            if (appointment == null) {
                throw new IllegalArgumentException("Appointment cannot be null");
            }
            appointments.add(appointment);
        } catch (Exception e) {
            System.err.println("Error adding appointment: " + e.getMessage());
        }
    }

    public void cancelAppointment(Appointment appointment) {
        try {
            if (appointment == null) {
                throw new IllegalArgumentException("Appointment cannot be null");
            }
            appointments.remove(appointment);
        } catch (Exception e) {
            System.err.println("Error cancelling appointment: " + e.getMessage());
        }
    }

    public void updateInfo(String phone, String address) {
        try {
            setPhone(phone);
            setAddress(address);
        } catch (Exception e) {
            System.err.println("Error updating patient info: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID: " + patientId + ", Full Name: " + fullName + ", Phone: " + phone + ", Address: " + address +
               ", Gender: " + gender + ", DOB: " + dob + ", Insurance Number: " + insuranceNumber;
    }
}