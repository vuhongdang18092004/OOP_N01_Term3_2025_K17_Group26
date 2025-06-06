package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String doctorName;
    private String patientName;
    private LocalDate date;
    private LocalTime time;
    private String room;

    public Appointment(String doctorName, String patientName, LocalDate date, LocalTime time, String room) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public String getDoctorName() { return doctorName; }
    public String getPatientName() { return patientName; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getRoom() { return room; }
}
