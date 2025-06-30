package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Appointment;
import com.example.servingwebcontent.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/appointments")
public class AdminAppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @GetMapping
    public String listAppointments(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String room,
            @RequestParam(required = false) String status,
            Model model) {

        List<Appointment> appointments = appointmentRepo.findAll(); // TODO: Bạn có thể lọc bằng custom query

        model.addAttribute("appointments", appointments);
        model.addAttribute("date", date);
        model.addAttribute("room", room);
        model.addAttribute("status", status);

        return "admin/appointments_list";
    }
}
