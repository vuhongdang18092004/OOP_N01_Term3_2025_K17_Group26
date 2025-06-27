package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.ShiftTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate, Long> {
    List<ShiftTemplate> findByDepartmentId(Long deptId);
}
