package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.*;
import com.example.servingwebcontent.repository.DoctorShiftRepository;
import com.example.servingwebcontent.repository.RoomRepository;
import com.example.servingwebcontent.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorShiftService {

    @Autowired
    private DoctorShiftRepository shiftRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private RoomRepository roomRepo;

    // Lấy danh sách ca trực của bác sĩ
    public List<DoctorShift> getShiftsByDoctorId(Long doctorId) {
        return shiftRepo.findByDoctorId(doctorId);
    }

    // Lấy tất cả phòng
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    // Lưu ca trực từ form (DoctorShift) với kiểm tra giới hạn và trùng ca
    public ShiftAddResult saveShift(Long doctorId, DoctorShift shift) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        List<DoctorShift> existingShifts = shiftRepo.findByDoctorId(doctorId);

        boolean isDuplicate = existingShifts.stream().anyMatch(s ->
            s.getDate().equals(shift.getDate()) &&
            s.getStartTime().equals(shift.getStartTime()) &&
            s.getEndTime().equals(shift.getEndTime())
        );

        if (isDuplicate) return ShiftAddResult.DUPLICATE_SHIFT;
        if (existingShifts.size() >= 3) return ShiftAddResult.MAX_SHIFT_REACHED;

        shift.setDoctor(doctor);
        shiftRepo.save(shift);
        return ShiftAddResult.SUCCESS;
    }

    // Lưu ca trực từ template (giao diện lịch)
    public ShiftAddResult saveShiftFromTemplate(Long doctorId, DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        List<DoctorShift> existingShifts = shiftRepo.findByDoctorId(doctorId);

        if (existingShifts.size() >= 3)
            return ShiftAddResult.MAX_SHIFT_REACHED;

        // Tìm ngày tiếp theo ứng với DayOfWeek
        LocalDate baseDate = LocalDate.now().with(dayOfWeek);
        LocalDate date = baseDate.isBefore(LocalDate.now()) ? baseDate.plusWeeks(1) : baseDate;

        boolean duplicate = existingShifts.stream().anyMatch(s ->
            s.getDate().equals(date) &&
            s.getStartTime().equals(start) &&
            s.getEndTime().equals(end)
        );

        if (duplicate) return ShiftAddResult.DUPLICATE_SHIFT;

        // Tự động chọn phòng đầu tiên của khoa bác sĩ
        Room room = roomRepo.findFirstByDepartmentId(doctor.getDepartment().getId());
        if (room == null) return ShiftAddResult.FAILURE;

        DoctorShift shift = new DoctorShift();
        shift.setDoctor(doctor);
        shift.setDate(date);
        shift.setStartTime(start);
        shift.setEndTime(end);
        shift.setRoom(room);

        shiftRepo.save(shift);
        return ShiftAddResult.SUCCESS;
    }

    // Xoá ca trực
    public void deleteShift(Long shiftId) {
        shiftRepo.deleteById(shiftId);
    }

    // Lấy tất cả ca trực khả dụng (dành cho đặt lịch)
    public List<DoctorShift> getAvailableShifts() {
        return shiftRepo.findAll();
    }

    // Lấy ca trực theo khoa (qua phòng)
    public List<DoctorShift> getShiftsByDepartment(Long departmentId) {
        return shiftRepo.findAll().stream()
                .filter(shift -> shift.getRoom().getDepartment().getId().equals(departmentId))
                .collect(Collectors.toList());
    }

    // Kiểm tra xem bác sĩ có thể thêm ca không
    public boolean canAddShift(Long doctorId, DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        List<DoctorShift> existing = shiftRepo.findByDoctorId(doctorId);

        if (existing.size() >= 3)
            return false;

        LocalDate baseDate = LocalDate.now().with(dayOfWeek);
        final LocalDate date = baseDate.isBefore(LocalDate.now()) ? baseDate.plusWeeks(1) : baseDate;

        return existing.stream().noneMatch(s ->
            s.getDate().equals(date) &&
            s.getStartTime().equals(start) &&
            s.getEndTime().equals(end)
        );
    }
}
