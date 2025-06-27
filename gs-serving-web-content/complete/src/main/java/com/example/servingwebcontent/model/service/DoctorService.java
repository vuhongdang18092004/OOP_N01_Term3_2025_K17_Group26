package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Doctor;
import com.example.servingwebcontent.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    public Optional<Doctor> findByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }
}
