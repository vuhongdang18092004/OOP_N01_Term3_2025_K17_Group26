// Lớp Main để kiểm tra
package com.project.HospitalManager;
import java.util.*;
import java.util.Scanner;

public class TestObjectList{
    public static void main(String[] args) throws Exception {
        // Tạo đối tượng Doctor
        Doctor doctor = new Doctor(1, "Nguyễn Văn B", "Nam", "0987654321", "78 Đường Nguyễn Huệ, TP.HCM", new java.text.SimpleDateFormat("dd-MM-yyyy").parse("01-01-1988"), "Nội khoa");
        System.out.println("Cập nhật thông tin bác sĩ:");
        doctor.updateInfo("0976543210", "456 Đường XYZ, TP.HCM");

        System.out.println("\n---\n");

        // Tạo đối tượng Patient
        Patient patient = new Patient(1, "Trần Văn A", "0901234567", "45 Đường Lê Lợi, TP.HCM", "Nam", new java.text.SimpleDateFormat("dd-MM-yyyy").parse("01-01-1990"), "123456789");
        System.out.println("Cập nhật thông tin bệnh nhân:");
        patient.updateInfo("0912345678", "123 Đường ABC, TP.HCM");

        Scanner scanner = new Scanner(System.in);

        // Cập nhật thông tin bác sĩ từ bàn phím
        System.out.println("\nNhập thông tin mới cho bác sĩ:");
        String newDoctorPhone;
        while (true) {
            System.out.print("Nhập số điện thoại mới: ");
            newDoctorPhone = scanner.nextLine();
            if (newDoctorPhone != null && newDoctorPhone.matches("\\d{10}")) break;
            System.out.println("Lỗi: Số điện thoại phải có đúng 10 chữ số. Vui lòng nhập lại!");
        }
        String newDoctorAddress;
        while (true) {
            System.out.print("Nhập địa chỉ mới: ");
            newDoctorAddress = scanner.nextLine();
            if (newDoctorAddress != null && !newDoctorAddress.trim().isEmpty()) break;
            System.out.println("Lỗi: Địa chỉ không được để trống. Vui lòng nhập lại!");
        }
        doctor.updateInfo(newDoctorPhone, newDoctorAddress);

        System.out.println("\n---\n");

        // Cập nhật thông tin bệnh nhân từ bàn phím
        System.out.println("Nhập thông tin mới cho bệnh nhân:");
        String newPatientPhone;
        while (true) {
            System.out.print("Nhập số điện thoại mới: ");
            newPatientPhone = scanner.nextLine();
            if (newPatientPhone != null && newPatientPhone.matches("\\d{10}")) break;
            System.out.println("Lỗi: Số điện thoại phải có đúng 10 chữ số. Vui lòng nhập lại!");
        }
        String newPatientAddress;
        while (true) {
            System.out.print("Nhập địa chỉ mới: ");
            newPatientAddress = scanner.nextLine();
            if (newPatientAddress != null && !newPatientAddress.trim().isEmpty()) break;
            System.out.println("Lỗi: Địa chỉ không được để trống. Vui lòng nhập lại!");
        }
        patient.updateInfo(newPatientPhone, newPatientAddress);

        // Test trường hợp lỗi
        System.out.println("\n---\n");
        System.out.println("Test trường hợp lỗi:");
        patient.updateInfo("123", ""); // Số điện thoại và địa chỉ không hợp lệ

        scanner.close();
    }
}