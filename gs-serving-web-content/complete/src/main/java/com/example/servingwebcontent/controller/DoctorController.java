package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.model.service.AppointmentService;
import com.example.servingwebcontent.model.service.DoctorShiftService;
import com.example.servingwebcontent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String viewShifts(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) Long roomId,
            @RequestParam(required = false) String status,
            Authentication authentication,
            Model model) {

        Doctor doctor = getDoctor(authentication);

        // Lấy danh sách ca trực đã lọc
        List<DoctorShift> shifts = doctorShiftService.filterShifts(doctor.getId(), date, roomId, status);
        model.addAttribute("shifts", shifts);

        // Để giữ lại giá trị trên form lọc
        model.addAttribute("filterDate", date);
        model.addAttribute("filterRoomId", roomId);
        // model.addAttribute("filterStatus", status);

        // Truyền danh sách phòng của khoa
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
                redirectAttributes.addFlashAttribute("error",
                        "Bạn chỉ được đăng ký tối đa 3 ca và không được trùng lặp!");
            } else {
                redirectAttributes.addFlashAttribute("success", "Đăng ký ca trực thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Lỗi đăng ký ca trực: " + e.getMessage());
        }
        return "redirect:/doctor/shifts";
    }

    @GetMapping("/shifts/edit/{id}")
    public String editShiftForm(@PathVariable Long id,
            Authentication authentication,
            Model model) {
        Doctor doctor = getDoctor(authentication);
        DoctorShift shift = doctorShiftService.getShift(id);

        // Chỉ cho phép chỉnh ca trực của chính bác sĩ
        if (!shift.getDoctor().getId().equals(doctor.getId())) {
            throw new RuntimeException("Bạn không được phép chỉnh ca trực này");
        }

        model.addAttribute("shift", shift);

        // Lấy danh sách phòng của khoa
        if (doctor.getDepartment() != null) {
            model.addAttribute("rooms", roomRepository.findByDepartmentId(doctor.getDepartment().getId()));
        } else {
            model.addAttribute("rooms", List.of());
        }

        return "doctor/edit_shift";
    }

    @PostMapping("/shifts/edit/{id}")
    public String updateShift(@PathVariable Long id,
            @RequestParam("date") String dateStr,
            @RequestParam("startTime") String startStr,
            @RequestParam("endTime") String endStr,
            @RequestParam("roomId") Long roomId,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {

        Doctor doctor = getDoctor(authentication);
        LocalDate date = LocalDate.parse(dateStr);
        LocalTime start = LocalTime.parse(startStr);
        LocalTime end = LocalTime.parse(endStr);

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));

        boolean success = doctorShiftService.updateShift(doctor.getId(), id, date, start, end, room);

        if (!success) {
            redirectAttributes.addFlashAttribute("error", "Ca trực bị trùng hoặc không hợp lệ!");
        } else {
            redirectAttributes.addFlashAttribute("success", "Cập nhật ca trực thành công!");
        }

        return "redirect:/doctor/shifts";
    }

    @GetMapping("/shifts/delete/{id}")
    public String deleteShift(@PathVariable Long id,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {
        Doctor doctor = getDoctor(authentication);
        DoctorShift shift = doctorShiftService.getShift(id);

        if (!shift.getDoctor().getId().equals(doctor.getId())) {
            throw new RuntimeException("Bạn không được phép xoá ca trực này");
        }

        doctorShiftService.deleteShift(id);
        redirectAttributes.addFlashAttribute("success", "Xoá ca trực thành công!");

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
    public String updateProfile(
            @ModelAttribute("doctor") Doctor formDoctor,
            @RequestParam(name = "password", required = false) String password,
            Authentication authentication,
            RedirectAttributes redirectAttributes) {
        try {
            Doctor doctor = getDoctor(authentication);

            // Cập nhật tên
            doctor.setFullName(formDoctor.getFullName());

            // Cập nhật khoa
            if (formDoctor.getDepartment() != null && formDoctor.getDepartment().getId() != null) {
                Department dept = departmentRepository.findById(formDoctor.getDepartment().getId())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy Khoa"));
                doctor.setDepartment(dept);
            } else {
                doctor.setDepartment(null);
            }

            // Cập nhật mật khẩu nếu có
            if (password != null && !password.isBlank()) {
                doctor.setPassword(passwordEncoder.encode(password));
            }

            // Không đụng vào username để giữ nguyên
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
