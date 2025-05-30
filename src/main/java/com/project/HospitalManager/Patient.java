package com.project.HospitalManager;
import java.util.Date;
import java.util.*;
// import com.project.HospitalManager.Appointment;

// Lớp Patient
public class Patient {
    private int patientId;
    private String fullName;
    private String phone;
    private String address;
    private String gender;  
    private Date dob;
    private String insuranceNumber;
    // private List<Appointment> appointments;

    // Constructor
    public Patient(int patientId, String fullName, String phone, String address, String gender, Date dob, String insuranceNumber) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.insuranceNumber = insuranceNumber;
    }

    // Phương thức updateInfo
    public void updateInfo(String phone, String address) {
        // Kiểm tra tính hợp lệ của số điện thoại
        if (phone == null || !phone.matches("\\d{10}")) {
            System.out.println("Lỗi: Số điện thoại phải có đúng 10 chữ số.");
            return;
        }

        // Kiểm tra tính hợp lệ của địa chỉ
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Lỗi: Địa chỉ không được để trống.");
            return;
        }

        // Cập nhật thông tin
        this.phone = phone;
        this.address = address;

        // Hiển thị thông tin sau khi cập nhật
        System.out.println("Thông tin bệnh nhân sau khi cập nhật:");
        System.out.println("- ID: " + patientId);
        System.out.println("- Họ tên: " + fullName);
        System.out.println("- Số điện thoại: " + phone);
        System.out.println("- Địa chỉ: " + address);
        System.out.println("- Giới tính: " + gender);
        System.out.println("- Ngày sinh: " + new java.text.SimpleDateFormat("dd-MM-yyyy").format(dob));
        System.out.println("- Số bảo hiểm: " + insuranceNumber);
    }

    // Getters
    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}