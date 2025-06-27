package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.model.service.AdminService;
import com.example.servingwebcontent.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private DepartmentService departmentService;

    // ========== DASHBOARD ==========
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    // ========== TẠO BÁC SĨ ==========
    @GetMapping("/create-doctor")
    public String createDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("departments", adminService.getAllDepartments());
        return "admin/create_doctor";
    }

    @PostMapping("/create-doctor")
    public String createDoctor(@ModelAttribute Doctor doctor) {
        Long deptId = doctor.getDepartment().getId();
        Department department = adminService.getDepartmentById(deptId);
        doctor.setDepartment(department);

        adminService.createDoctor(doctor);
        return "redirect:/admin/doctors?success=true";
    }

    // ========== QUẢN LÝ BÁC SĨ ==========
    @GetMapping("/doctors")
    public String viewDoctors(@RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long departmentId,
            Model model) {
        List<Doctor> doctors = adminService.searchDoctors(id, name, departmentId);
        model.addAttribute("doctors", doctors);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("searchId", id);
        model.addAttribute("searchName", name);
        model.addAttribute("selectedDepartmentId", departmentId);
        return "admin/manage_doctor";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        Doctor doctor = adminService.getDoctorById(id);
        if (doctor == null)
            return "redirect:/admin/doctors";
        model.addAttribute("doctor", doctor);
        model.addAttribute("departments", adminService.getAllDepartments());
        return "admin/edit-doctor";
    }

    @PostMapping("/doctors/edit/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctor) {
        Department dept = adminService.getDepartmentById(doctor.getDepartment().getId());
        doctor.setDepartment(dept);
        adminService.updateDoctor(id, doctor);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        adminService.deleteDoctor(id);
        return "redirect:/admin/doctors";
    }

    // ========== QUẢN LÝ PHÒNG ==========
    @GetMapping("/rooms")
    public String manageRooms(@RequestParam(required = false) String id,
            @RequestParam(required = false) String roomNumber,
            @RequestParam(required = false) Long departmentId,
            Model model) {

        model.addAttribute("rooms", adminService.filterRooms(id, roomNumber, departmentId));
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("newRoom", new Room());
        model.addAttribute("searchId", id);
        model.addAttribute("searchRoomNumber", roomNumber);
        model.addAttribute("selectedDepartmentId", departmentId);
        return "admin/manage_room";
    }

    @PostMapping("/rooms")
    public String addRoom(@ModelAttribute Room room) {
        Department department = adminService.getDepartmentById(room.getDepartment().getId());
        room.setDepartment(department);
        adminService.saveRoom(room);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        adminService.deleteRoom(id);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    public String editRoomForm(@PathVariable Long id, Model model) {
        Room room = adminService.getRoomById(id);
        if (room == null)
            return "redirect:/admin/rooms";
        model.addAttribute("room", room);
        model.addAttribute("departments", adminService.getAllDepartments());
        return "admin/edit_room";
    }

    @PostMapping("/rooms/edit/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute Room updatedRoom) {
        Department dept = adminService.getDepartmentById(updatedRoom.getDepartment().getId());
        updatedRoom.setDepartment(dept);
        adminService.updateRoom(id, updatedRoom);
        return "redirect:/admin/rooms";
    }
}
