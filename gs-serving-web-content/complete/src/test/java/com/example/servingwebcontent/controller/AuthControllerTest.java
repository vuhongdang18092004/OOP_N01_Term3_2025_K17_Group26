package com.example.servingwebcontent.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /login should return login page")
    void testShowLoginForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Đăng nhập")));
    }

    @Test
    @DisplayName("GET /register should return 200 OK")
    void testShowRegisterFormOk() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /access-denied should return 200 when authenticated")
    @WithMockUser
    void testAccessDenied() throws Exception {
        mockMvc.perform(get("/access-denied"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /login with admin credentials should redirect to /admin/dashboard")
    void testLoginWithAdmin() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "admin")
                        .param("password", "1234567")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/dashboard"));
    }

    @Test
    @DisplayName("GET /admin/dashboard with admin should be accessible")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testAdminDashboardAccess() throws Exception {
        mockMvc.perform(get("/admin/dashboard"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /doctor/dashboard with admin should be forbidden")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testDoctorDashboardForbiddenForAdmin() throws Exception {
        mockMvc.perform(get("/doctor/dashboard"))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("GET /patient/dashboard with admin should be forbidden")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testPatientDashboardForbiddenForAdmin() throws Exception {
        mockMvc.perform(get("/patient/dashboard"))
                .andExpect(status().isForbidden());
    }
}
