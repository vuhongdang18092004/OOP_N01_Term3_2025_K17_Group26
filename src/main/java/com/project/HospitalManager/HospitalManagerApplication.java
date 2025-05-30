package com.project.HospitalManager;

import java.util.Date;
import java.util.Scanner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.project.HospitalManager.*;

// @SpringBootApplication
public class HospitalManagerApplication {

	public static void main(String[] args) {
		// SpringApplication.run(HospitalManagerApplication.class, args);
		Doctor doctor = new Doctor(1, "Nguyễn Văn B", "0987654321", "78 Đường Nguyễn Huệ, TP.HCM", "Nam", new Date(), "Nội khoa");
        System.out.println("Cập nhật thông tin bác sĩ:");
        doctor.updateInfo("0976543210", "456 Đường XYZ, TP.HCM");

        System.out.println("\n---\n");

        // Tạo đối tượng Patient
        Patient patient = new Patient(1, "Trần Văn A", "0901234567", "45 Đường Lê Lợi, TP.HCM", "Nam", new Date(), "123456789");
        System.out.println("Cập nhật thông tin bệnh nhân:");
        patient.updateInfo("0912345678", "123 Đường ABC, TP.HCM");

        Scanner scanner = new Scanner(System.in);

		// Cập nhật thông tin bác sĩ từ bàn phím
		System.out.println("\nNhập thông tin mới cho bác sĩ:");
		System.out.print("Nhập số điện thoại mới: ");
		String newDoctorPhone = scanner.nextLine();
		System.out.print("Nhập địa chỉ mới: ");
		String newDoctorAddress = scanner.nextLine();
		doctor.updateInfo(newDoctorPhone, newDoctorAddress);

		System.out.println("\n---\n");

		// Cập nhật thông tin bệnh nhân từ bàn phím
		System.out.println("Nhập thông tin mới cho bệnh nhân:");
		System.out.print("Nhập số điện thoại mới: ");
		String newPatientPhone = scanner.nextLine();
		System.out.print("Nhập địa chỉ mới: ");
		String newPatientAddress = scanner.nextLine();
		patient.updateInfo(newPatientPhone, newPatientAddress);

		// Test trường hợp lỗi
		System.out.println("\n---\n");
		System.out.println("Test trường hợp lỗi:");
		patient.updateInfo("123", ""); // Số điện thoại và địa chỉ không hợp lệ

		scanner.close();
	}

}
