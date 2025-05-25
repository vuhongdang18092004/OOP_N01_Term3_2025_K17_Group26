// import java.time.LocalDate;

// public class testDoctor {
//     public static void main(String[] args) {
//         WorkSchedule schedule = new WorkSchedule("Thứ 2 - Thứ 6: 8h - 17h");

//         // Tạo đối tượng Doctor
//         Doctor doc = new Doctor(
//             "D001", 
//             "Nguyễn Văn A", 
//             "Nam", 
//             LocalDate.of(1980, 3, 15),
//             "0909123456", 
//             "123 Đường ABC, TP.HCM", 
//             "Nội tổng quát", 
//             schedule, 
//             "P101"
//         );

//         // Kiểm tra thông tin
//         System.out.println(doc.getInfo());
//         doc.displayInfo();
//         doc.viewWorkSchedule();

//         // Cập nhật lịch làm việc mới
//         WorkSchedule newSchedule = new WorkSchedule("Thứ 2 - Thứ 7: 7h30 - 16h30");
//         doc.updateWorkSchedule(newSchedule);
//         System.out.println("Đã cập nhật lịch:");
//         doc.viewWorkSchedule();
//     }
// }



import java.util.Scanner;
import java.time.LocalDate;

public class testDoctor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorList dtList = new DoctorList();
        int choice;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Thêm bác sĩ");
            System.out.println("2. Sửa thông tin bác sĩ");
            System.out.println("3. Xóa bác sĩ");
            System.out.println("4. Hiển thị danh sách bác sĩ");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập họ tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập giới tính: ");
                    String gender = sc.nextLine();

                    System.out.print("Nhập địa chỉ: ");
                    String address = sc.nextLine();

                    System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(sc.nextLine());

                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine();

                    Doctor newDoctor = new Doctor(name, id, gender, address, dob, phone);
                    dtList.addDoctor(newDoctor);
                    break;

                case 2:
                    System.out.print("Nhập ID bác sĩ cần sửa: ");
                    int editId = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();

                    System.out.print("Nhập giới tính mới: ");
                    String newGender = sc.nextLine();

                    System.out.print("Nhập địa chỉ mới: ");
                    String newAddress = sc.nextLine();

                    System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
                    LocalDate newDob = LocalDate.parse(sc.nextLine());

                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = sc.nextLine();

                    dtList.editDoctor(editId, newName, newGender, newAddress, newDob, newPhone);
                    break;

                case 3:
                    System.out.print("Nhập ID bác sĩ cần xóa: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    dtList.deleteDoctor(delId);
                    break;

                case 4:
                    dtList.printDoctorList();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 5);

        sc.close();
    }
}
