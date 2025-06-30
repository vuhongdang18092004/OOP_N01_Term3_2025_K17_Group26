package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/patients")
public class AdminPatientController {

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping
    public String listPatients(@RequestParam(required = false) String keyword, Model model) {
        try {
            List<Patient> patients;
            if (keyword != null && !keyword.isEmpty()) {
                patients = patientRepo.findByFullNameContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCaseOrAddressContainingIgnoreCase(
                        keyword, keyword, keyword, keyword
                );
            } else {
                patients = patientRepo.findAll();
            }
            model.addAttribute("patients", patients);
            model.addAttribute("keyword", keyword);
        } catch (Exception e) {
            model.addAttribute("error", "Đã xảy ra lỗi khi tải danh sách bệnh nhân: " + e.getMessage());
        }
        return "admin/patients_list";
    }
}
