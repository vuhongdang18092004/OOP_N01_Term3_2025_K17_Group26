package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Appointment;
import com.example.servingwebcontent.model.entity.DoctorShift;
import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.AppointmentRepository;
import com.example.servingwebcontent.repository.DoctorShiftRepository;
import com.example.servingwebcontent.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorShiftRepository shiftRepo;

    public List<DoctorShift> getAvailableShifts() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(3);
        LocalDate end = today.plusDays(10);
        return shiftRepo.findByDateBetweenOrderByDateAsc(start, end);
    }

    @Transactional
    public void bookAppointment(Long patientId, Long shiftId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân có ID: " + patientId));
        DoctorShift shift = shiftRepo.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ca trực có ID: " + shiftId));

        if (!"AVAILABLE".equalsIgnoreCase(shift.getStatus())) {
            throw new RuntimeException("Ca trực này không khả dụng.");
        }

        boolean exists = appointmentRepo.existsByDoctorShiftIdAndStatusNot(shiftId, "CANCELLED");
        if (exists) {
            throw new RuntimeException("Ca trực này đã được đặt trước đó.");
        }

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctorShift(shift);
        appointment.setStatus("PENDING");
        appointment.setBookingTime(LocalDateTime.now());
        appointmentRepo.save(appointment);

        shift.setStatus("PENDING");
        shiftRepo.save(shift);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepo.findByPatientIdOrderByBookingTimeDesc(patientId);
    }

    public List<Appointment> getAppointmentsForPatientByDate(Long patientId, LocalDate date) {
        return appointmentRepo.findByPatientIdAndDoctorShiftDateOrderByBookingTimeDesc(patientId, date);
    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepo.findByDoctorShiftDoctorIdOrderByBookingTimeDesc(doctorId);
    }

    @Transactional
    public void updateAppointmentStatus(Long appointmentId, String status) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn có ID: " + appointmentId));
        appointment.setStatus(status);

        if ("COMPLETE".equalsIgnoreCase(status)) {
            DoctorShift shift = appointment.getDoctorShift();
            shift.setStatus("COMPLETE");
            shiftRepo.save(shift);
        }
        appointmentRepo.save(appointment);
    }

    @Transactional
    public Long cancelAppointment(Long appointmentId) {
        Appointment a = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn có ID: " + appointmentId));

        DoctorShift shift = a.getDoctorShift();
        shift.setStatus("AVAILABLE");
        shiftRepo.save(shift);

        appointmentRepo.delete(a);

        return a.getPatient().getId();
    }

    public List<Appointment> getAppointmentsForDoctorByDate(Long doctorId, LocalDate date) {
    return appointmentRepo.findByDoctorShiftDoctorIdAndDoctorShiftDateOrderByBookingTimeDesc(doctorId, date);
}

}
