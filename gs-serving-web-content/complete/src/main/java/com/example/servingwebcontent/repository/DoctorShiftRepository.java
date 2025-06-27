package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.DoctorShift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DoctorShiftRepository extends JpaRepository<DoctorShift, Long> {
    List<DoctorShift> findByDoctorId(Long doctorId);
    List<DoctorShift> findByDateBetweenOrderByDateAsc(LocalDate start, LocalDate end);

}
