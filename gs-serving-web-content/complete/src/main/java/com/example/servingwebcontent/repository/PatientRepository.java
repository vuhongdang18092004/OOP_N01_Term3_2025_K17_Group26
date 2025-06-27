package com.example.servingwebcontent.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.model.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUsername(String username);
    boolean existsByUsername(String username);
}
