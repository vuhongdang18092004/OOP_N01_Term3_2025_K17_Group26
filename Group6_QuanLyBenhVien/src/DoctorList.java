import java.time.LocalDate;
import java.util.ArrayList;

public class DoctorList {
    ArrayList<Doctor> listDoctor = new ArrayList<>();

    public void addDoctor(Doctor dt) {
        listDoctor.add(dt);
        System.out.println("Thêm bác sĩ thành công!");
    }

    public void editDoctor(int doctorID, String fullname, String gender, String address, LocalDate dateOfBirth, String phoneNumber) {
        for (Doctor d : listDoctor) {
            if (d.doctorId == doctorID) {
                d.fullname = fullname;
                d.gender = gender;
                d.address = address;
                d.dateOfBirth = dateOfBirth;
                d.phoneNumber = phoneNumber;
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bác sĩ với ID đã nhập.");
    }

    public void deleteDoctor(int doctorID) {
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).doctorId == doctorID) {
                listDoctor.remove(i);
                System.out.println("Xóa bác sĩ thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bác sĩ với ID đã nhập.");
    }

    public void printDoctorList() {
        if (listDoctor.isEmpty()) {
            System.out.println("Danh sách bác sĩ trống.");
            return;
        }

        System.out.println("\n=== DANH SÁCH BÁC SĨ ===");
        for (Doctor d : listDoctor) {
            System.out.println("ID: " + d.doctorId +
                    ", Họ tên: " + d.fullname +
                    ", Giới tính: " + d.gender +
                    ", Địa chỉ: " + d.address +
                    ", Ngày sinh: " + d.dateOfBirth +
                    ", SĐT: " + d.phoneNumber);
        }
        System.out.println("=========================");
    }
}
