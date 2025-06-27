package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.*;
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

    /**
     * Lấy danh sách lịch khám khả dụng trong 2 tuần tới
     */
    public List<DoctorShift> getAvailableShifts() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.minusDays(3); // ví dụ từ 3 ngày trước
        LocalDate end = today.plusDays(10);   // đến 10 ngày sau

        return shiftRepo.findByDateBetweenOrderByDateAsc(start, end);
    }

    /**
     * Bệnh nhân đặt lịch
     */
    public void bookAppointment(Long patientId, Long shiftId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân"));
        DoctorShift shift = shiftRepo.findById(shiftId).orElseThrow(() -> new RuntimeException("Không tìm thấy ca trực"));

        // Kiểm tra xem ca trực đã được đặt chưa
        if (appointmentRepo.existsByDoctorShiftIdAndStatusNot(shiftId, AppointmentStatus.CANCELLED)) {
            throw new RuntimeException("Ca trực này đã được đặt");
        }

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctorShift(shift);
        appointment.setStatus(AppointmentStatus.PENDING);
        appointment.setBookingTime(LocalDateTime.now());

        appointmentRepo.save(appointment);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepo.findByPatientIdOrderByBookingTimeDesc(patientId);
    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepo.findByDoctorShiftDoctorIdOrderByBookingTimeDesc(doctorId);
    }

    @Transactional
    public void updateAppointmentStatus(Long appointmentId, AppointmentStatus status) {
        Appointment a = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn"));
        a.setStatus(status);
    }

    public void cancelAppointment(Long appointmentId) {
        Appointment a = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn"));
        if (a.getBookingTime().plusHours(24).isAfter(LocalDateTime.now())) {
            a.setStatus(AppointmentStatus.CANCELLED);
            appointmentRepo.save(a);
        } else {
            throw new RuntimeException("Không thể hủy vì đã quá thời gian cho phép");
        }
    }
}
