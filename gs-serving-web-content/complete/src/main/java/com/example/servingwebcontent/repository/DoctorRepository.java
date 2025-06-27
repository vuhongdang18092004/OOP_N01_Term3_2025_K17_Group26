package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUsername(String username);

    List<Doctor> findByDepartmentId(Long departmentId);

    List<Doctor> findByDepartment_Id(Long departmentId);

    List<Doctor> findByFullNameContainingIgnoreCase(String fullName);

    List<Doctor> findByFullNameContainingIgnoreCaseAndDepartmentId(String fullName, Long departmentId);

}
