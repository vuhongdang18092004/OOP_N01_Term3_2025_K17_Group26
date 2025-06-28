package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.entity.DoctorShift;
import com.example.servingwebcontent.model.service.DoctorShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shifts")
public class DoctorShiftController {

    @Autowired
    private DoctorShiftService shiftService;

    // Danh sách ca trực bác sĩ
    @GetMapping("/doctor/{doctorId}")
    public String list(@PathVariable Long doctorId, Model model) {
        model.addAttribute("shifts", shiftService.getShiftsByDoctor(doctorId));
        model.addAttribute("doctorId", doctorId);
        return "shifts/list";
    }

    // Form thêm mới
    @GetMapping("/doctor/{doctorId}/add")
    public String addForm(@PathVariable Long doctorId, Model model) {
        DoctorShift shift = new DoctorShift();
        shift.setStatus("PENDING");
        model.addAttribute("shift", shift);
        model.addAttribute("doctorId", doctorId);
        return "shifts/form";
    }

    // Lưu mới hoặc chỉnh sửa
    @PostMapping("/doctor/{doctorId}/save")
    public String save(@PathVariable Long doctorId, @ModelAttribute DoctorShift shift, Model model) {
        boolean isDuplicate = shiftService.isDuplicateShift(
                doctorId,
                shift.getDate(),
                shift.getStartTime(),
                shift.getEndTime()
        );
        if (isDuplicate) {
            model.addAttribute("error", "Ca trực đã tồn tại.");
            model.addAttribute("doctorId", doctorId);
            return "shifts/form";
        }
        shiftService.saveShift(doctorId, shift);
        return "redirect:/shifts/doctor/" + doctorId;
    }

    // Form chỉnh sửa
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        DoctorShift shift = shiftService.getShift(id);
        model.addAttribute("shift", shift);
        model.addAttribute("doctorId", shift.getDoctor().getId());
        return "shifts/form";
    }

    // Xác nhận hoàn thành
    @PostMapping("/{id}/complete")
    public String complete(@PathVariable Long id) {
        DoctorShift shift = shiftService.getShift(id);
        shiftService.completeShift(id);
        return "redirect:/shifts/doctor/" + shift.getDoctor().getId();
    }
}
