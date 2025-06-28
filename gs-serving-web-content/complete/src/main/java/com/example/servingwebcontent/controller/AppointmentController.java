package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Hiển thị danh sách ca khám trống để đặt lịch
    @GetMapping("/book")
    public String showAvailableShifts(Model model) {
        model.addAttribute("shifts", appointmentService.getAvailableShifts());
        return "patient/book_appointment";
    }

    // Đặt lịch khám
    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long patientId, @RequestParam Long shiftId) {
        try {
            appointmentService.bookAppointment(patientId, shiftId);
            return "redirect:/appointments/history?success=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/appointments/book?error=" + e.getMessage();
        }
    }

    // Xem lịch sử khám của bệnh nhân
    @GetMapping("/history")
    public String viewPatientAppointments(@RequestParam Long patientId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(patientId));
        return "patient/history";
    }

    // Bác sĩ xem lịch hẹn
    @GetMapping("/doctor")
    public String viewDoctorAppointments(@RequestParam Long doctorId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForDoctor(doctorId));
        return "doctor/appointments";
    }

    // Bác sĩ cập nhật trạng thái lịch hẹn
    @PostMapping("/update-status")
    public String updateStatus(@RequestParam Long id, @RequestParam String status) {
        try {
            appointmentService.updateAppointmentStatus(id, status);
            return "redirect:/appointments/doctor?updated=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/appointments/doctor?error=" + e.getMessage();
        }
    }

    // Hủy lịch hẹn
    @PostMapping("/cancel")
    public String cancelAppointment(@RequestParam Long id) {
        try {
            appointmentService.cancelAppointment(id);
            return "redirect:/appointments/history?cancelled=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/appointments/history?error=" + e.getMessage();
        }
    }
}
