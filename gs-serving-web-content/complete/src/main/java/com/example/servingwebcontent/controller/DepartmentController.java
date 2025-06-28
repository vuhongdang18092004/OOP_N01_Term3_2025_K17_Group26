package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.Department;
import com.example.servingwebcontent.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/departments")
public class DepartmentController {

    @Autowired
    private AdminService adminService;

    // Hiển thị danh sách + tìm kiếm
    @GetMapping
    public String listDepartments(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            Model model) {

        List<Department> departments;

        try {
            if (id != null) {
                Department d = adminService.getDepartmentById(id);
                departments = (d != null) ? List.of(d) : List.of();
            } else if (name != null && !name.isBlank()) {
                departments = adminService.findDepartmentsByNameContaining(name);
            } else {
                departments = adminService.getAllDepartments();
            }

            model.addAttribute("departments", departments);
            model.addAttribute("newDepartment", new Department());
            model.addAttribute("searchId", id);
            model.addAttribute("searchName", name);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi tải danh sách khoa: " + e.getMessage());
        }

        return "admin/manage_department";
    }

    // Thêm khoa mới
    @PostMapping
    public String addDepartment(@ModelAttribute Department department) {
        try {
            adminService.saveDepartment(department);
            return "redirect:/admin/departments?success=added";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/departments?error=" + e.getMessage();
        }
    }

    // Xoá khoa
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        try {
            adminService.deleteDepartment(id);
            return "redirect:/admin/departments?success=deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/departments?error=" + e.getMessage();
        }
    }

    // Mở form chỉnh sửa khoa
    @GetMapping("/edit/{id}")
    public String editDepartmentForm(@PathVariable Long id, Model model) {
        try {
            Department department = adminService.getDepartmentById(id);
            if (department == null) {
                return "redirect:/admin/departments?error=notfound";
            }
            model.addAttribute("department", department);
            return "admin/edit_department";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/departments?error=" + e.getMessage();
        }
    }

    // Xử lý cập nhật khoa
    @PostMapping("/edit")
    public String updateDepartment(@ModelAttribute Department department) {
        try {
            adminService.saveDepartment(department);
            return "redirect:/admin/departments?success=updated";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/departments?error=" + e.getMessage();
        }
    }
}
