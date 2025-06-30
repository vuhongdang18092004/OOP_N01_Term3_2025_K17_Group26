package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Lịch sử đặt của bệnh nhân
    List<Appointment> findByPatientIdOrderByBookingTimeDesc(Long patientId);

    List<Appointment> findByPatientIdAndDoctorShiftDateOrderByBookingTimeDesc(Long patientId, LocalDate date);

    // Lịch khám của bác sĩ
    List<Appointment> findByDoctorShiftDoctorIdOrderByBookingTimeDesc(Long doctorId);

    List<Appointment> findByDoctorShiftDoctorIdAndDoctorShiftDateOrderByBookingTimeDesc(Long doctorId, LocalDate date);

    // Kiểm tra ca trực đã được đặt chưa
    boolean existsByDoctorShiftIdAndStatusNot(Long shiftId, String status);

    // Lịch hẹn cho Admin: lọc theo ngày, phòng, trạng thái
    @Query("""
        SELECT a FROM Appointment a
        WHERE (:date IS NULL OR a.doctorShift.date = :date)
          AND (:room IS NULL OR a.doctorShift.room.roomNumber = :room)
          AND (:status IS NULL OR a.status = :status)
        ORDER BY a.bookingTime DESC
    """)
    List<Appointment> searchAppointmentsForAdmin(
            @Param("date") LocalDate date,
            @Param("room") String room,
            @Param("status") String status
    );
}
