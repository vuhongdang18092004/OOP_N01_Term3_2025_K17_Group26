package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.AppointmentStatus;
import com.example.servingwebcontent.model.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired private AppointmentService appointmentService;

    // === ĐẶT LỊCH KHÁM ===
    @GetMapping("/book")
    public String showAvailableShifts(Model model) {
        model.addAttribute("shifts", appointmentService.getAvailableShifts());
        return "patient/book_appointment";
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long patientId, @RequestParam Long shiftId) {
        appointmentService.bookAppointment(patientId, shiftId);
        return "redirect:/appointments/history?success=true";
    }

    // === XEM LỊCH SỬ KHÁM CỦA BỆNH NHÂN ===
    @GetMapping("/history")
    public String viewPatientAppointments(@RequestParam Long patientId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForPatient(patientId));
        return "patient/history";
    }

    // === BÁC SĨ XEM LỊCH KHÁM ===
    @GetMapping("/doctor")
    public String viewDoctorAppointments(@RequestParam Long doctorId, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsForDoctor(doctorId));
        return "doctor/appointments";
    }

    // === BÁC SĨ CẬP NHẬT TRẠNG THÁI ===
    @PostMapping("/update-status")
    public String updateStatus(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        appointmentService.updateAppointmentStatus(id, status);
        return "redirect:/appointments/doctor";
    }

    // === HỦY LỊCH TRONG 24H ===
    @PostMapping("/cancel")
    public String cancelAppointment(@RequestParam Long id) {
        try {
            appointmentService.cancelAppointment(id);
        } catch (RuntimeException e) {
            return "redirect:/appointments/history?error=" + e.getMessage();
        }
        return "redirect:/appointments/history?cancelled=true";
    }
}
