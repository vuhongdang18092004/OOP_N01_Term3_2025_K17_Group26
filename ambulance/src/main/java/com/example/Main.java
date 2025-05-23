package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Thêm phương tiện cứu thương
        Ambulance ambulance1 = new Ambulance(1L, "29A-12345", "Standard", 4);
        ambulance1.addAmbulance();

        // Khởi tạo người lái, bác sĩ và bệnh nhân
        User driver = new User(1L, "Nguyen Van A", "Driver");
        Doctor doctor = new Doctor(1L, "Dr. Le Thi B", "Cardiology");
        Patient patient = new Patient(1L, "Tran Van C", LocalDate.of(1985, 10, 12), "Heart attack");

        // Gán chuyến đi cho xe cứu thương
        AmbulanceTrip trip1 = new AmbulanceTrip(1L, "Ha Noi Hospital", "Emergency call", ambulance1, driver, doctor, patient);
        ambulance1.assignTrip(trip1);
        trip1.startTrip();

        // Kết thúc chuyến đi
        trip1.endTrip();
    }
}
