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

        //Test thêm bác sĩ
        Doctor doctor1 = new Doctor("Do Thi My Hanh", 101, "Female", "Ha Nọi", LocalDate.of(2004, 1, 23), "0123456789");
        Doctor doctor2 = new Doctor("Ha Tien Anh", 102, "Male", "Ha Noi", LocalDate.of(2004, 11, 29), "0987654321");

        // Thêm bác sĩ vào danh sách
        dtList.addDoctor(doctor1);
        dtList.addDoctor(doctor2);

        // Hiển thị danh sách bác sĩ
        System.out.println("Danh sách bác sĩ sau khi thêm:");
        dtList.printDoctorList();

        // Test sửa thông tin bác sĩ
        dtList.editDoctor(101, "Do Thi My Hanh", "Male", "40 Ha Noi", LocalDate.of(2004, 1, 23), "0983023029");

        System.out.println("\nDanh sách bác sĩ sau khi sửa:");
        dtList.printDoctorList();

        // Xóa bác sĩ có ID 102
        dtList.deleteDoctor(102);

        //In lại danh sách
        System.out.println("\nDanh sách bác sĩ sau khi xóa:");
        dtList.printDoctorList();
    }
}