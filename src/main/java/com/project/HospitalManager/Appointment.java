package com.project.HospitalManager;
import java.util.*;
public class Appointment {
    private Date appointmentTime;
    private String status;

    public Appointment(Date appointmentTime, String status) {
        this.appointmentTime = appointmentTime;
        this.status = status;
    }
}
