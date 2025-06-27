package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;
import com.example.servingwebcontent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.DayOfWeek;
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
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ShiftTemplateRepository shiftTemplateRepo;
    @Autowired
    private DoctorShiftRepository shiftRepo;

    // Trang chính
    @GetMapping("/dashboard")
    public String doctorDashboard(Model model, Authentication authentication) {
        Long doctorId = getDoctorId(authentication);
        model.addAttribute("doctorId", doctorId);
        return "doctor/dashboard";
    }

    // Lịch hẹn
    @GetMapping("/appointments")
    public String viewAppointments(Authentication authentication, Model model) {
        Long doctorId = getDoctorId(authentication);
        model.addAttribute("appointments", appointmentService.getAppointmentsForDoctor(doctorId));
        return "doctor/appointments";
    }

    @PostMapping("/appointments/update-status")
    public String updateAppointmentStatus(@RequestParam Long id,
            @RequestParam AppointmentStatus status,
            Authentication authentication) {
        appointmentService.updateAppointmentStatus(id, status);
        return "redirect:/doctor/appointments";
    }

    // Quản lý ca trực
    @GetMapping("/shifts")
    public String viewShifts(Authentication authentication, Model model) {
        Long doctorId = getDoctorId(authentication);
        model.addAttribute("shifts", doctorShiftService.getShiftsByDoctorId(doctorId));
        model.addAttribute("newShift", new DoctorShift());
        model.addAttribute("rooms", doctorShiftService.getAllRooms());
        return "doctor/manage_shifts";
    }

    @PostMapping("/shifts")
    public String addShift(@RequestParam("day") DayOfWeek day,
            @RequestParam("startTime") String startStr,
            @RequestParam("endTime") String endStr,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        Long doctorId = getDoctorId(authentication);
        LocalTime start = LocalTime.parse(startStr);
        LocalTime end = LocalTime.parse(endStr);

        ShiftAddResult result = doctorShiftService.saveShiftFromTemplate(doctorId, day, start, end);

        if (result != ShiftAddResult.SUCCESS) {
            redirectAttributes.addFlashAttribute("error", "Bạn chỉ được đăng ký tối đa 3 ca và không được trùng lặp!");
        } else {
            redirectAttributes.addFlashAttribute("success", "Đăng ký ca trực thành công!");
        }

        return "redirect:/doctor/shifts/select";
    }

    // Hồ sơ cá nhân
    @GetMapping("/profile")
    public String viewProfile(Model model, Authentication authentication) {
        Long doctorId = getDoctorId(authentication);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ"));
        model.addAttribute("doctor", doctor);
        model.addAttribute("departments", departmentRepository.findAll());
        return "doctor/profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute("doctor") Doctor formDoctor,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {
        Long doctorId = getDoctorId(authentication);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ"));

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
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công!");
        return "redirect:/doctor/profile";
    }

    // Giao diện chọn ca trực từ shift template (nếu dùng)
    @GetMapping("/shifts/select")
    public String showShiftSelection(Model model, Authentication auth) {
        Doctor doctor = getDoctor(auth);
        Long deptId = doctor.getDepartment().getId();

        List<ShiftTemplate> templates = shiftTemplateRepo.findByDepartmentId(deptId);
        List<DoctorShift> selected = shiftRepo.findByDoctorId(doctor.getId());

        model.addAttribute("templates", templates);
        model.addAttribute("selectedShifts", selected);
        model.addAttribute("selectedShiftCount", selected.size());

        return "doctor/select_shifts";
    }

    private Long getDoctorId(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getDoctor().getId();
    }

    private Doctor getDoctor(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getDoctor();
    }
}
