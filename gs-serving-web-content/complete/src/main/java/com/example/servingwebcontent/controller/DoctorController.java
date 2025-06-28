package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;
import com.example.servingwebcontent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorShiftService doctorShiftService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Trang chính
    @GetMapping("/dashboard")
    public String doctorDashboard(Model model, Authentication authentication) {
        Doctor doctor = getDoctor(authentication);
        model.addAttribute("doctorId", doctor.getId());
        return "doctor/dashboard";
    }

    // Lịch hẹn
    @GetMapping("/appointments")
    public String viewAppointments(Authentication authentication, Model model) {
        Doctor doctor = getDoctor(authentication);
        model.addAttribute("appointments", appointmentService.getAppointmentsForDoctor(doctor.getId()));
        return "doctor/appointments";
    }

    @PostMapping("/appointments/update-status")
    public String updateAppointmentStatus(@RequestParam Long id,
                                          @RequestParam String status,
                                          RedirectAttributes redirectAttributes) {
        try {
            appointmentService.updateAppointmentStatus(id, status);
            redirectAttributes.addFlashAttribute("success", "Cập nhật trạng thái thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi cập nhật trạng thái: " + e.getMessage());
        }
        return "redirect:/doctor/appointments";
    }

    // Quản lý ca trực
    @GetMapping("/shifts")
    public String viewShifts(Authentication authentication, Model model) {
        Doctor doctor = getDoctor(authentication);

        model.addAttribute("shifts", doctorShiftService.getShiftsByDoctor(doctor.getId()));
        model.addAttribute("newShift", new DoctorShift());

        if (doctor.getDepartment() != null) {
            model.addAttribute("rooms", roomRepository.findByDepartmentId(doctor.getDepartment().getId()));
        } else {
            model.addAttribute("rooms", List.of());
        }
        return "doctor/manage_shifts";
    }

    @PostMapping("/shifts")
    public String addShift(@RequestParam("date") String dateStr,
                           @RequestParam("startTime") String startStr,
                           @RequestParam("endTime") String endStr,
                           @RequestParam("roomId") Long roomId,
                           Authentication authentication,
                           RedirectAttributes redirectAttributes) {
        try {
            Doctor doctor = getDoctor(authentication);
            LocalDate date = LocalDate.parse(dateStr);
            LocalTime start = LocalTime.parse(startStr);
            LocalTime end = LocalTime.parse(endStr);

            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));

            boolean success = doctorShiftService.saveShiftWithRoom(doctor.getId(), date, start, end, room);

            if (!success) {
                redirectAttributes.addFlashAttribute("error", "Bạn chỉ được đăng ký tối đa 3 ca và không được trùng lặp!");
            } else {
                redirectAttributes.addFlashAttribute("success", "Đăng ký ca trực thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi đăng ký ca trực: " + e.getMessage());
        }
        return "redirect:/doctor/shifts";
    }

    // Hồ sơ cá nhân
    @GetMapping("/profile")
    public String viewProfile(Model model, Authentication authentication) {
        Doctor doctor = getDoctor(authentication);
        model.addAttribute("doctor", doctor);
        model.addAttribute("departments", departmentRepository.findAll());
        return "doctor/profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("doctor") Doctor formDoctor,
                                Authentication authentication,
                                RedirectAttributes redirectAttributes) {
        try {
            Doctor doctor = getDoctor(authentication);

            doctor.setUsername(formDoctor.getUsername());
            doctor.setFullName(formDoctor.getFullName());

            if (formDoctor.getPassword() != null && !formDoctor.getPassword().isBlank()) {
                doctor.setPassword(passwordEncoder.encode(formDoctor.getPassword()));
            }

            if (formDoctor.getDepartment() != null && formDoctor.getDepartment().getId() != null) {
                Department dept = departmentRepository.findById(formDoctor.getDepartment().getId()).orElse(null);
                doctor.setDepartment(dept);
            }

            doctorRepository.save(doctor);
            redirectAttributes.addFlashAttribute("success", "Cập nhật hồ sơ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi cập nhật hồ sơ: " + e.getMessage());
        }
        return "redirect:/doctor/profile";
    }

    private Doctor getDoctor(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return doctorRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ"));
    }
}
