package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientIdOrderByBookingTimeDesc(Long patientId);

    List<Appointment> findByDoctorShiftDoctorIdOrderByBookingTimeDesc(Long doctorId);

    boolean existsByDoctorShiftIdAndStatusNot(Long shiftId, String status);
}
