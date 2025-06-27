package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // Bạn có thể thêm các phương thức custom nếu cần, ví dụ:
    Room findFirstByDepartmentId(Long departmentId);

    List<Room> findByDepartmentId(Long departmentId);
}
