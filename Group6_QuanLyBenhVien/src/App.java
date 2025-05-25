import java.time.LocalDate;

public class App {
    // public static void main(String[] args) {
    //     new Patient("P001", "Nguyen Van A", "Hanoi");
    //     new Patient("P002", "Tran Thi B", "HCMC");
    //     new Patient("P003", "Le Van C", "Da Nang");

    //     System.out.println("Danh sach ban dau:");
    //     Patient.showAllPatients();

    //     System.out.println("\nChinh sua Nguyen Van A:");
    //     Patient.editAddressByName("Nguyen Van A", "Hai Phong");

    //     System.out.println("\nSau khi sua:");
    //     Patient.showAllPatients();
    // }


     public static void main(String[] args) {
        DoctorList dtList = new DoctorList();

        // Tạo bác sĩ mới
        Doctor doctor1 = new Doctor("Nguyen Van A", \n 101, "Male", "123 Street A", LocalDate.of(1980, 5, 15), "0123456789");
        Doctor doctor2 = new Doctor("Le Thi B", 102, "Female", "456 Street B", LocalDate.of(1985, 8, 20), "0987654321");

        // Thêm bác sĩ vào danh sách
        dtList.addDoctor(doctor1);
        dtList.addDoctor(doctor2);

        // Hiển thị danh sách bác sĩ
        System.out.println("Danh sách bác sĩ sau khi thêm:");
        dtList.printDoctorList();

        // Sửa thông tin bác sĩ
        dtList.editDoctor(101, "Nguyen Van A Updated", "Male", "789 Street C", LocalDate.of(1980, 5, 15), "0112233445");

        System.out.println("\nDanh sách bác sĩ sau khi sửa:");
        dtList.printDoctorList();

        // Xóa bác sĩ theo ID
        dtList.deleteDoctor(102);

        System.out.println("\nDanh sách bác sĩ sau khi xóa:");
        dtList.printDoctorList();
    }
}