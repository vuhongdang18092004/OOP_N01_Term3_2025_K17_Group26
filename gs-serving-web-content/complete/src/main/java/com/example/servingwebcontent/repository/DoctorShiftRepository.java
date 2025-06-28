package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.DoctorShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DoctorShiftRepository extends JpaRepository<DoctorShift, Long> {
    List<DoctorShift> findByDoctorId(Long doctorId);

    long countByDoctorId(Long doctorId);

    List<DoctorShift> findByDateBetweenOrderByDateAsc(LocalDate start, LocalDate end);

    boolean existsByDoctorIdAndDateAndStartTimeAndEndTime(
            Long doctorId,
            LocalDate date,
            java.time.LocalTime startTime,
            java.time.LocalTime endTime);

    // Các ca khám trống (status = 'AVAILABLE')
    List<DoctorShift> findByStatus(String status);

    // Ca trống theo bác sĩ
    List<DoctorShift> findByDoctorIdAndStatus(Long doctorId, String status);

    // Ca trống theo khoa
    @Query("SELECT s FROM DoctorShift s WHERE s.doctor.department.id = :deptId AND s.status = :status")
    List<DoctorShift> findByDepartmentAndStatus(@Param("deptId") Long departmentId, @Param("status") String status);
}
