package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Department;
import com.example.servingwebcontent.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> optional = departmentRepo.findById(id);
        return optional.orElse(null);
    }

    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }

    public List<Department> searchDepartments(String idStr, String name) {
        if (idStr != null && !idStr.isBlank()) {
            try {
                Long id = Long.parseLong(idStr);
                Optional<Department> optional = departmentRepo.findById(id);
                return optional.map(List::of).orElse(List.of());
            } catch (NumberFormatException e) {
                return List.of(); // Không tìm thấy nếu id không hợp lệ
            }
        } else if (name != null && !name.isBlank()) {
            return departmentRepo.findByNameContainingIgnoreCase(name);
        } else {
            return departmentRepo.findAll();
        }
    }
}
