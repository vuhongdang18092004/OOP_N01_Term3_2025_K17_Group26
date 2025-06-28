package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.PatientRepository;
import com.example.servingwebcontent.repository.DepartmentRepository;
import com.example.servingwebcontent.repository.DoctorRepository;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // Lịch sử đặt khám
    @GetMapping("/history")
    public String viewHistory(@RequestParam Long patientId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(patientId));
        return "patient/history";
    }

    // Form đặt lịch khám
    @GetMapping("/book")
    public String showBookingForm(
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Long doctorId,
            Model model
    ) {
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());

        if (doctorId != null) {
            model.addAttribute("shifts", doctorShiftService.getAvailableShiftsByDoctor(doctorId));
        } else if (departmentId != null) {
            model.addAttribute("shifts", doctorShiftService.getAvailableShiftsByDepartment(departmentId));
        } else {
            model.addAttribute("shifts", doctorShiftService.getAvailableShifts());
        }

        return "patient/book_appointment";
    }

    // Xử lý đặt lịch khám
    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long patientId,
                                  @RequestParam Long shiftId,
                                  RedirectAttributes redirectAttributes) {
        try {
            appointmentService.bookAppointment(patientId, shiftId);
            redirectAttributes.addFlashAttribute("success", "Đặt lịch thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi đặt lịch: " + e.getMessage());
        }
        return "redirect:/patient/history?patientId=" + patientId;
    }

    // Trang quản lý thông tin cá nhân
    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        Patient patient = getPatient(principal);
        model.addAttribute("patient", patient);
        return "patient/profile";
    }

    // Form chỉnh sửa thông tin cá nhân
    @GetMapping("/profile/edit")
    public String editProfile(Model model, Principal principal) {
        Patient patient = getPatient(principal);
        model.addAttribute("patient", patient);
        return "patient/edit_profile";
    }

    // Xử lý cập nhật thông tin cá nhân
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
            existing.setUsername(updatedPatient.getUsername());

            if (updatedPatient.getPassword() != null && !updatedPatient.getPassword().isBlank()) {
                existing.setPassword(passwordEncoder.encode(updatedPatient.getPassword()));
            }

            patientRepository.save(existing);
            redirectAttributes.addFlashAttribute("success", "Cập nhật thông tin thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi cập nhật: " + e.getMessage());
        }

        return "redirect:/patient/profile";
    }

    private Patient getPatient(Principal principal) {
        return patientRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Patient not found"));
    }
}
