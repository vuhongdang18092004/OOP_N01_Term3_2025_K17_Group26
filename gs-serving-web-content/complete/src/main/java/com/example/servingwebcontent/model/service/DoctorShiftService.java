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
    
    public List<DoctorShift> getShiftsByDoctor(Long doctorId) {
        return shiftRepo.findByDoctorId(doctorId);
    }

    public DoctorShift getShift(Long shiftId) {
        return shiftRepo.findById(shiftId).orElseThrow(() -> new RuntimeException("Không tìm thấy ca trực"));
    }

    public boolean isDuplicateShift(Long doctorId, LocalDate date, LocalTime start, LocalTime end) {
        return shiftRepo.findByDoctorId(doctorId).stream()
                .anyMatch(s -> s.getDate().equals(date) &&
                        s.getStartTime().equals(start) &&
                        s.getEndTime().equals(end));
    }

    public void saveShift(Long doctorId, DoctorShift shift) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        shift.setDoctor(doctor);
        shiftRepo.save(shift);
    }

    public void completeShift(Long shiftId) {
        DoctorShift shift = shiftRepo.findById(shiftId).orElseThrow();
        shift.setStatus("COMPLETED");
        shiftRepo.save(shift);
    }

    public List<DoctorShift> getAvailableShifts() {
        return shiftRepo.findAll().stream()
                .filter(s -> "AVAILABLE".equals(s.getStatus()))
                .toList();
    }

    public List<DoctorShift> getAvailableShiftsByDoctor(Long doctorId) {
        return shiftRepo.findByDoctorId(doctorId).stream()
                .filter(s -> "AVAILABLE".equals(s.getStatus()))
                .toList();
    }

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

        // Kiểm tra trùng ca (giao nhau)
        boolean duplicate = shiftRepo.findByDoctorId(doctorId).stream()
                .anyMatch(s -> s.getDate().equals(date) &&
                        !(end.isBefore(s.getStartTime()) || end.equals(s.getStartTime()) ||
                                start.isAfter(s.getEndTime()) || start.equals(s.getEndTime())));
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

    public boolean updateShift(Long doctorId, Long shiftId, LocalDate date, LocalTime start, LocalTime end, Room room) {
        DoctorShift shift = shiftRepo.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ca trực"));

        if (!shift.getDoctor().getId().equals(doctorId)) {
            throw new RuntimeException("Bạn không được phép chỉnh ca trực này");
        }

        //Kiểm tra trùng lặp với các ca khác (bỏ qua chính ca này)
        boolean duplicate = shiftRepo.findByDoctorId(doctorId).stream()
                .filter(s -> !s.getId().equals(shiftId))
                .anyMatch(s -> s.getDate().equals(date) &&
                        !(end.isBefore(s.getStartTime()) || end.equals(s.getStartTime()) ||
                                start.isAfter(s.getEndTime()) || start.equals(s.getEndTime())));
        if (duplicate) {
            return false;
        }

        //Cập nhật dữ liệu
        shift.setDate(date);
        shift.setStartTime(start);
        shift.setEndTime(end);
        shift.setRoom(room);

        shiftRepo.save(shift);
        return true;
    }

    public void deleteShift(Long shiftId) {
        shiftRepo.deleteById(shiftId);
    }

    public List<DoctorShift> filterShifts(Long doctorId, LocalDate date, Long roomId, String status) {
        return shiftRepo.findByDoctorId(doctorId).stream()
                .filter(s -> date == null || s.getDate().equals(date))
                .filter(s -> roomId == null || (s.getRoom() != null && s.getRoom().getId().equals(roomId)))
                .toList();
    }

}