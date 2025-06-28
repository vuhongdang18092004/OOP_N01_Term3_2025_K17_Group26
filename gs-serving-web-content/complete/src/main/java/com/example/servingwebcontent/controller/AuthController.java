package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.model.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    // Hiển thị form đăng nhập
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute Patient patient, Model model) {
        try {
            if (authService.findOptionalByUsername(patient.getUsername()).isPresent()) {
                model.addAttribute("error", "Tên người dùng đã tồn tại!");
                return "register";
            }
            authService.registerPatient(patient);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Đăng ký thất bại: " + e.getMessage());
            return "register";
        }
    }

    // Trang báo lỗi quyền truy cập
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
