package com.project.HospitalManager;

import java.time.LocalDateTime;

public class Ex_TestObjectList {
    public static void main(String[] args) {
        try {
            // Initialize ObjectList for each type
            ObjectList<Doctor> doctorList = new ObjectList<>();
            ObjectList<Patient> patientList = new ObjectList<>();
            ObjectList<Appointment> appointmentList = new ObjectList<>();

            // Test CRUD for Doctor
            System.out.println("\n=== Testing Doctor CRUD ===");
            Doctor doctor1 = new Doctor(1, "Dr. Smith", "Male", "1980-01-01", "Cardiology");
            Doctor doctor2 = new Doctor(2, "Dr. Johnson", "Female", "1975-05-10", "Neurology");

            // Create
            doctorList.create(doctor1);
            doctorList.create(doctor2);

            // Read
            doctorList.read(1).ifPresent(System.out::println);

            // Update
            Doctor updatedDoctor = new Doctor(1, "Dr. Smith Jr.", "Male", "1980-01-01", "Cardiology");
            doctorList.update(1, updatedDoctor);

            // Delete
            doctorList.delete(2);

            // Test CRUD for Patient
            System.out.println("\n=== Testing Patient CRUD ===");
            Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Male", "1990-03-15", "INS123");
            Patient patient2 = new Patient(2, "Jane Roe", "0987654321", "456 Oak St", "Female", "1985-07-20", "INS456");

            // Create
            patientList.create(patient1);
            patientList.create(patient2);

            // Read
            patientList.read(1).ifPresent(System.out::println);

            // Update
            Patient updatedPatient = new Patient(1, "John Doe", "1234567890", "789 Pine St", "Male", "1990-03-15", "INS123");
            patientList.update(1, updatedPatient);

            // Delete
            patientList.delete(2);

            // Test CRUD for Appointment
            System.out.println("\n=== Testing Appointment CRUD ===");
            Appointment appointment1 = new Appointment(1, "Checkup", LocalDateTime.now().plusDays(1), "Scheduled", doctor1, patient1);
            Appointment appointment2 = new Appointment(2, "Follow-up", LocalDateTime.now().plusDays(2), "Scheduled", doctor1, patient1);

            // Associate appointments
            doctor1.addAppointment(appointment1);
            patient1.addAppointment(appointment1);
            doctor1.addAppointment(appointment2);
            patient1.addAppointment(appointment2);

            // Create
            appointmentList.create(appointment1);
            appointmentList.create(appointment2);

            // Read
            appointmentList.read(1).ifPresent(System.out::println);

            // Update
            Appointment updatedAppointment = new Appointment(1, "Checkup", LocalDateTime.now().plusDays(3), "Scheduled", doctor1, patient1);
            appointmentList.update(1, updatedAppointment);

            // Delete
            appointmentList.delete(2);

        } catch (Exception e) {
            System.err.println("Error in test execution: " + e.getMessage());
        }
    }
}