package com.example.servingwebcontent.model.service;

import com.example.servingwebcontent.model.entity.Doctor;
import com.example.servingwebcontent.model.entity.DoctorShift;
import com.example.servingwebcontent.model.entity.Room;
import com.example.servingwebcontent.repository.DoctorRepository;
import com.example.servingwebcontent.repository.DoctorShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DoctorShiftService {

    private LocalDate date;

    @Autowired
    private DoctorShiftRepository shiftRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    /**
     * Lấy tất cả ca trực của bác sĩ
     */
    public List<DoctorShift> getShiftsByDoctor(Long doctorId) {
        return shiftRepo.findByDoctorId(doctorId);
    }

    /**
     * Lấy một ca trực theo ID
     */
    public DoctorShift getShift(Long shiftId) {
        return shiftRepo.findById(shiftId).orElseThrow(() -> new RuntimeException("Không tìm thấy ca trực"));
    }

    /**
     * Kiểm tra ca trực bị trùng
     */
    public boolean isDuplicateShift(Long doctorId, LocalDate date, LocalTime start, LocalTime end) {
        return shiftRepo.findByDoctorId(doctorId).stream()
                .anyMatch(s -> s.getDate().equals(date) &&
                        s.getStartTime().equals(start) &&
                        s.getEndTime().equals(end));
    }

    /**
     * Lưu ca trực
     */
    public void saveShift(Long doctorId, DoctorShift shift) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        shift.setDoctor(doctor);
        shiftRepo.save(shift);
    }

    /**
     * Đánh dấu ca trực hoàn thành
     */
    public void completeShift(Long shiftId) {
        DoctorShift shift = shiftRepo.findById(shiftId).orElseThrow();
        shift.setStatus("COMPLETED");
        shiftRepo.save(shift);
    }

    /**
     * Lấy tất cả ca trực trống
     */
    public List<DoctorShift> getAvailableShifts() {
        return shiftRepo.findAll().stream()
                .filter(s -> "AVAILABLE".equals(s.getStatus()))
                .toList();
    }

    /**
     * Lấy ca trực trống theo bác sĩ
     */
    public List<DoctorShift> getAvailableShiftsByDoctor(Long doctorId) {
        return shiftRepo.findByDoctorId(doctorId).stream()
                .filter(s -> "AVAILABLE".equals(s.getStatus()))
                .toList();
    }

    /**
     * Lấy ca trực trống theo khoa
     */
    public List<DoctorShift> getAvailableShiftsByDepartment(Long departmentId) {
        return shiftRepo.findAll().stream()
                .filter(s -> "AVAILABLE".equals(s.getStatus()) && 
                            s.getDoctor().getDepartment().getId().equals(departmentId))
                .toList();
    }

    public boolean saveShiftFromDateTime(Long doctorId, LocalDate date, LocalTime start, LocalTime end) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();

        // Kiểm tra trùng ca
        boolean duplicate = shiftRepo.findByDoctorId(doctorId).stream()
                .anyMatch(s -> s.getDate().equals(date) &&
                        s.getStartTime().equals(start) &&
                        s.getEndTime().equals(end));
        if (duplicate) {
            return false;
        }

        // Kiểm tra số ca tối đa 3
        long count = shiftRepo.findByDoctorId(doctorId).size();
        if (count >= 3) {
            return false;
        }

        DoctorShift shift = new DoctorShift();
        shift.setDoctor(doctor);
        shift.setDate(date);
        shift.setStartTime(start);
        shift.setEndTime(end);
        shift.setStatus("AVAILABLE");

        shiftRepo.save(shift);
        return true;
    }

    public boolean saveShiftWithRoom(Long doctorId, LocalDate date, LocalTime start, LocalTime end, Room room) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();

        // Kiểm tra trùng ca
        boolean duplicate = shiftRepo.findByDoctorId(doctorId).stream()
                .anyMatch(s -> s.getDate().equals(date) &&
                        s.getStartTime().equals(start) &&
                        s.getEndTime().equals(end));
        if (duplicate) {
            return false;
        }

        // Kiểm tra số ca tối đa 3
        long count = shiftRepo.findByDoctorId(doctorId).size();
        if (count >= 3) {
            return false;
        }

        // Tạo mới ca trực
        DoctorShift shift = new DoctorShift();
        shift.setDoctor(doctor);
        shift.setDate(date);
        shift.setStartTime(start);
        shift.setEndTime(end);
        shift.setRoom(room);
        shift.setStatus("AVAILABLE");

        shiftRepo.save(shift);
        return true;
    }
}