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
            System.out.println("1. Add doctors");
            System.out.println("2. Edit doctor information");
            System.out.println("3. Delete doctor");
            System.out.println("4. Display doctor list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter fullname: ");
                    String name = sc.nextLine();

                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter date of birth (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(sc.nextLine());

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    Doctor newDoctor = new Doctor(name, id, gender, address, dob, phone);
                    dtList.addDoctor(newDoctor);
                    break;

                case 2:
                    System.out.print("Enter the ID of the doctor to edit: ");
                    int editId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter new fullname: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new gender: ");
                    String newGender = sc.nextLine();

                    System.out.print("Enter new address: ");
                    String newAddress = sc.nextLine();

                    System.out.print("Enter new date of birth (yyyy-mm-dd): ");
                    LocalDate newDob = LocalDate.parse(sc.nextLine());

                    System.out.print("Enter new phone number: ");
                    String newPhone = sc.nextLine();

                    dtList.editDoctor(editId, newName, newGender, newAddress, newDob, newPhone);
                    break;

                case 3:
                    System.out.print("Enter the ID of the doctor do delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    dtList.deleteDoctor(delId);
                    break;

                case 4:
                    dtList.printDoctorList();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
