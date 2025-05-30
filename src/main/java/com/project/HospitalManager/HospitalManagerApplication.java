package com.project.HospitalManager;

import java.util.Date;
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

        // Test trường hợp lỗi
        System.out.println("\n---\n");
        System.out.println("Test trường hợp lỗi:");
        patient.updateInfo("123", ""); // Số điện thoại và địa chỉ không hợp lệ	
	}

}
