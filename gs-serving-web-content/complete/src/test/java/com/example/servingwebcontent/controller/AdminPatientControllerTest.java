package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Patient;
import com.example.servingwebcontent.repository.PatientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminPatientController.class)
class AdminPatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientRepository patientRepository;

    @Test
    @DisplayName("GET /admin/patients without keyword returns all patients")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testListPatientsWithoutKeyword() throws Exception {
        Patient p1 = Mockito.mock(Patient.class);
        Patient p2 = Mockito.mock(Patient.class);

        when(patientRepository.findAll()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/admin/patients"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/patients_list"))
                .andExpect(model().attributeExists("patients"))
                .andExpect(model().attribute("patients", hasSize(2)));
    }

    @Test
    @DisplayName("GET /admin/patients with keyword returns filtered patients")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testListPatientsWithKeyword() throws Exception {
        Patient p1 = Mockito.mock(Patient.class);

        when(patientRepository.findByFullNameContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrEmailContainingIgnoreCaseOrAddressContainingIgnoreCase(
                "abc", "abc", "abc", "abc"))
                .thenReturn(List.of(p1));

        mockMvc.perform(get("/admin/patients").param("keyword", "abc"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/patients_list"))
                .andExpect(model().attributeExists("patients"))
                .andExpect(model().attribute("patients", hasSize(1)))
                .andExpect(model().attribute("keyword", "abc"));
    }

    @Test
    @DisplayName("GET /admin/patients when repository throws exception should show error message")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testListPatientsException() throws Exception {
        when(patientRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(get("/admin/patients"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/patients_list"))
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attribute("error", org.hamcrest.Matchers.containsString("Đã xảy ra lỗi")));
    }
}
