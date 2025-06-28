package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.model.entity.CustomUserDetails;
import com.example.servingwebcontent.model.entity.Doctor;
import com.example.servingwebcontent.repository.PatientRepository;
import com.example.servingwebcontent.repository.DoctorRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public CustomUserDetailsService(PatientRepository patientRepository,
            DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Admin cố định
        if (username.equals("admin")) {
            return User.builder()
                    .username("admin")
                    .password("$2a$10$6vPJSUJPry95BISlje48xeljC0MHG.U.V15d2S9Idf4tYbvZN0f1q")
                    .roles("ADMIN")
                    .build();
        }

        // Patient
        Patient patient = patientRepository.findByUsername(username).orElse(null);
        if (patient != null) {
            return new CustomUserDetails(
                    patient.getUsername(),
                    patient.getPassword(),
                    List.of(() -> "ROLE_PATIENT"),
                    null,
                    patient);
        }

        // Doctor
        Doctor doctor = doctorRepository.findByUsername(username).orElse(null);
        if (doctor != null) {
            return new CustomUserDetails(
                    doctor.getUsername(),
                    doctor.getPassword(),
                    List.of(() -> "ROLE_DOCTOR"),
                    doctor,
                    null);
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }

}
