package com.example.servingwebcontent.model.entity;

import com.example.servingwebcontent.repository.*;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.List;

@Component
public class DataSeeder {

    @Autowired
    private ShiftTemplateRepository shiftTemplateRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private RoomRepository roomRepo;

    @PostConstruct
    public void seedShiftTemplates() {
        if (shiftTemplateRepo.count() > 0) return;

        List<Department> departments = departmentRepo.findAll();

        for (Department dept : departments) {
            List<Room> rooms = roomRepo.findByDepartmentId(dept.getId());

            if (rooms.isEmpty()) {
                System.out.println("❌ Khoa '" + dept.getName() + "' không có phòng nào.");
                continue;
            }

            Room defaultRoom = rooms.get(0); // chọn phòng đầu tiên

            for (DayOfWeek day : DayOfWeek.values()) {
                shiftTemplateRepo.save(new ShiftTemplate(day, LocalTime.of(6, 30), LocalTime.of(12, 0), dept, defaultRoom));
                shiftTemplateRepo.save(new ShiftTemplate(day, LocalTime.of(13, 30), LocalTime.of(19, 0), dept, defaultRoom));
            }
        }

        System.out.println("✅ Seed ShiftTemplate hoàn tất.");
    }
}
