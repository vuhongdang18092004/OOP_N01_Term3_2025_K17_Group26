package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.repository.AppointmentRepository;
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

@WebMvcTest(AdminAppointmentController.class)
class AdminAppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Test
    @DisplayName("GET /admin/appointments should return list view with appointments")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testListAppointments() throws Exception {
        // Mock Patient
        Patient patient = Mockito.mock(Patient.class);
        when(patient.getFullName()).thenReturn("Nguyen Van A");

        // Mock Department
        Department department = Mockito.mock(Department.class);
        when(department.getName()).thenReturn("Khoa Nội");

        // Mock Doctor
        Doctor doctor = Mockito.mock(Doctor.class);
        when(doctor.getFullName()).thenReturn("Bac Si B");
        when(doctor.getDepartment()).thenReturn(department);

        // Mock DoctorShift
        DoctorShift doctorShift = Mockito.mock(DoctorShift.class);
        when(doctorShift.getDoctor()).thenReturn(doctor);

        // Mock Appointment
        Appointment appt1 = Mockito.mock(Appointment.class);
        when(appt1.getPatient()).thenReturn(patient);
        when(appt1.getDoctorShift()).thenReturn(doctorShift);

        Appointment appt2 = Mockito.mock(Appointment.class);
        when(appt2.getPatient()).thenReturn(patient);
        when(appt2.getDoctorShift()).thenReturn(doctorShift);

        when(appointmentRepository.findAll())
                .thenReturn(List.of(appt1, appt2));

        mockMvc.perform(get("/admin/appointments"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/appointments_list"))
                .andExpect(model().attributeExists("appointments"))
                .andExpect(model().attribute("appointments", hasSize(2)));
    }
}
