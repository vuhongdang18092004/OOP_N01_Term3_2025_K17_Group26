package com.example.servingwebcontent.model.entity;

import jakarta.persistence.*;

@Entity
public class Patient extends User {

    private String phone;
    private String email;
    private String address;

    // === Getters & Setters ===

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
