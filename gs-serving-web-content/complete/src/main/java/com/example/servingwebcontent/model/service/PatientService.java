package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }
}