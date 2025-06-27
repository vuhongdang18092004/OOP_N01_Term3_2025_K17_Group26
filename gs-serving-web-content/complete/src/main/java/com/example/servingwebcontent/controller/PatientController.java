package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.PatientRepository;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorShiftService doctorShiftService;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        Patient patient = patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));
        model.addAttribute("patient", patient); // ✅ Truyền biến vào Thymeleaf
        return "patient/dashboard";
    }

    // ✅ Lịch sử đặt khám
    @GetMapping("/history")
    public String viewHistory(@RequestParam Long patientId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(patientId));
        return "patient/history";
    }

    // ✅ Form đặt lịch khám
    @GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("shifts", doctorShiftService.getAvailableShifts());
        return "patient/book_appointment";
    }

    // ✅ Xử lý đặt lịch khám
    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long patientId, @RequestParam Long shiftId) {
        appointmentService.bookAppointment(patientId, shiftId);
        return "redirect:/patient/history?patientId=" + patientId;
    }

    // ✅ Trang quản lý thông tin cá nhân
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        Patient patient = patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));

        model.addAttribute("patient", patient);
        return "patient/profile"; // Tạo file templates/patient/profile.html
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model, Principal principal) {
        Patient patient = patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));
        model.addAttribute("patient", patient);
        return "patient/edit_profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute Patient updatedPatient, Principal principal) {
        Patient existing = patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));

        existing.setFullName(updatedPatient.getFullName());
        existing.setEmail(updatedPatient.getEmail());
        existing.setPhone(updatedPatient.getPhone());
        existing.setAddress(updatedPatient.getAddress());
        existing.setUsername(updatedPatient.getUsername());

        // Nếu người dùng nhập mật khẩu mới, thì mã hóa và cập nhật
        if (updatedPatient.getPassword() != null && !updatedPatient.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(updatedPatient.getPassword()));
        }

        patientRepository.save(existing);
        return "redirect:/patient/profile";
    }

}
