package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // ========== BÁC SĨ ==========
    public void createDoctor(Doctor doctor) {
        doctor.setPassword(encoder.encode(doctor.getPassword()));
        doctor.setRole(UserRole.DOCTOR);
        doctorRepo.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }

    public void updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepo.findById(id).orElse(null);
        if (existingDoctor != null) {
            existingDoctor.setUsername(updatedDoctor.getUsername());
            existingDoctor.setFullName(updatedDoctor.getFullName());
            // existingDoctor.setEmail(updatedDoctor.getEmail());
            // existingDoctor.setPhone(updatedDoctor.getPhone());
            existingDoctor.setDepartment(updatedDoctor.getDepartment());
            // Không thay đổi mật khẩu tại đây nếu không có yêu cầu
            doctorRepo.save(existingDoctor);
        }
    }

    public void deleteDoctor(Long id) {
        doctorRepo.deleteById(id);
    }

    public List<Doctor> searchDoctors(Long id, String name, Long departmentId) {
        if (id != null) {
            return doctorRepo.findById(id).map(List::of).orElse(List.of());
        }

        if (name != null && !name.isBlank() && departmentId != null) {
            return doctorRepo.findByFullNameContainingIgnoreCaseAndDepartmentId(name, departmentId);
        } else if (name != null && !name.isBlank()) {
            return doctorRepo.findByFullNameContainingIgnoreCase(name);
        } else if (departmentId != null) {
            return doctorRepo.findByDepartmentId(departmentId);
        } else {
            return doctorRepo.findAll();
        }
    }

    // ========== KHOA ==========
    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }

    public void saveDepartment(Department department) {
        deptRepo.save(department);
    }

    public void deleteDepartment(Long id) {
        deptRepo.deleteById(id);
    }

    public Department getDepartmentById(Long id) {
        return deptRepo.findById(id).orElse(null);
    }

    public List<Department> findDepartmentsByNameContaining(String name) {
        return deptRepo.findByNameContainingIgnoreCase(name);
    }

    // ========== PHÒNG ==========
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public void saveRoom(Room room) {
        roomRepo.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }

    public Room getRoomById(Long id) {
        return roomRepo.findById(id).orElse(null);
    }

    public void updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepo.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setDepartment(updatedRoom.getDepartment());
            roomRepo.save(existingRoom);
        }
    }

    public List<Room> filterRooms(String id, String roomNumber, Long departmentId) {
        return roomRepo.findAll().stream()
                .filter(r -> {
                    boolean match = true;

                    if (id != null && !id.isBlank()) {
                        try {
                            Long roomId = Long.parseLong(id);
                            match &= r.getId().equals(roomId);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }

                    if (roomNumber != null && !roomNumber.isBlank()) {
                        match &= r.getRoomNumber().toLowerCase().contains(roomNumber.toLowerCase());
                    }

                    if (departmentId != null) {
                        match &= r.getDepartment() != null &&
                                r.getDepartment().getId().equals(departmentId);
                    }

                    return match;
                })
                .toList();
    }

    // ========== ADMIN ==========
    public Admin findAdminByUsername(String username) {
        return adminRepo.findByUsername(username).orElseThrow();
    }
}
