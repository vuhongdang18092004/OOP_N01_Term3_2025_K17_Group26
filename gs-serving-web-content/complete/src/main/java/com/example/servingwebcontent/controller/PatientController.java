package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.*;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

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

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Dashboard
    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        Patient patient = getPatient(principal);
        model.addAttribute("patient", patient);
        return "patient/dashboard";
    }

    // Trang đặt lịch khám
    @GetMapping("/book")
    public String showBookingForm(
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Long doctorId,
            Model model,
            Principal principal) {
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());

        if (doctorId != null) {
            model.addAttribute("shifts", doctorShiftService.getAvailableShiftsByDoctor(doctorId));
        } else if (departmentId != null) {
            model.addAttribute("shifts", doctorShiftService.getAvailableShiftsByDepartment(departmentId));
        } else {
            model.addAttribute("shifts", doctorShiftService.getAvailableShifts());
        }

        model.addAttribute("patient", getPatient(principal));
        return "patient/book_appointment";
    }

    // Quản lý hồ sơ
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        model.addAttribute("patient", getPatient(principal));
        return "patient/profile";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model, Principal principal) {
        model.addAttribute("patient", getPatient(principal));
        return "patient/edit_profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute Patient updatedPatient,
            Principal principal,
            RedirectAttributes redirectAttributes) {
        try {
            Patient existing = getPatient(principal);
            existing.setFullName(updatedPatient.getFullName());
            existing.setEmail(updatedPatient.getEmail());
            existing.setPhone(updatedPatient.getPhone());
            existing.setAddress(updatedPatient.getAddress());

            if (updatedPatient.getPassword() != null && !updatedPatient.getPassword().isBlank()) {
                existing.setPassword(passwordEncoder.encode(updatedPatient.getPassword()));
            }

            patientRepository.save(existing);
            redirectAttributes.addFlashAttribute("success", "Cập nhật thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi: " + e.getMessage());
        }
        return "redirect:/patient/profile";
    }

    private Patient getPatient(Principal principal) {
        return patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));
    }

    // Lịch sử khám
    @GetMapping("/history")
    public String viewHistory(
            @RequestParam(required = false) Long shiftId,
            Model model,
            Principal principal) {

        Patient patient = getPatient(principal);

        // Lấy tất cả lịch hẹn của bệnh nhân
        var appointments = appointmentService.getAppointmentsForPatient(patient.getId());

        // Sắp xếp PENDING trước
        appointments.sort((a, b) -> {
            if (a.getStatus().equals(b.getStatus()))
                return 0;
            if (a.getStatus().equals("PENDING"))
                return -1;
            if (b.getStatus().equals("PENDING"))
                return 1;
            return 0;
        });

        model.addAttribute("appointments", appointments);
        model.addAttribute("patient", patient);

        return "patient/history";
    }

}
