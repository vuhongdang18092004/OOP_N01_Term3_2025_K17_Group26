package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Appointment;
import com.example.servingwebcontent.model.entity.Doctor;
import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.repository.DoctorRepository;
import com.example.servingwebcontent.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Lịch sử khám bệnh
    @GetMapping("/history")
    public String viewPatientAppointments(
            Authentication authentication,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        Patient patient = getPatient(authentication);
        List<Appointment> appointments = (date != null)
                ? appointmentService.getAppointmentsForPatientByDate(patient.getId(), date)
                : appointmentService.getAppointmentsForPatient(patient.getId());

        appointments.sort(Comparator.comparing(a -> {
            switch (a.getStatus()) {
                case "PENDING": return 0;
                case "COMPLETE": return 1;
                case "CANCELLED": return 2;
                default: return 99;
            }
        }));

        model.addAttribute("appointments", appointments);
        model.addAttribute("selectedDate", date);
        return "patient/history";
    }

    // Huỷ lịch
    @PostMapping("/cancel")
    public String cancelAppointment(@RequestParam Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointments/history?cancelled=true";
    }

    // Lịch của bác sĩ
    @GetMapping("/doctor")
    public String viewDoctorAppointments(
            Authentication authentication,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Doctor doctor = doctorRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));

        List<Appointment> appointments = (date != null)
                ? appointmentService.getAppointmentsForDoctorByDate(doctor.getId(), date)
                : appointmentService.getAppointmentsForDoctor(doctor.getId());

        model.addAttribute("appointments", appointments);
        model.addAttribute("selectedDate", date);
        return "doctor/appointments";
    }

    private Patient getPatient(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return patientRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));
    }
}
