package com.example.servingwebcontent.model.entity;

import jakarta.persistence.*;

@Entity
public class Doctor extends User {


    @ManyToOne
    private Department department;


    // public String getSpecialization() {
    //     return specialization;
    // }

    // public void setSpecialization(String specialization) {
    //     this.specialization = specialization;
    // }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
