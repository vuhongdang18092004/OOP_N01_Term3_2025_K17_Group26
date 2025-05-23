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



import java.util.ArrayList;
import java.util.Scanner;

public class testDoctor {
     ArrayList<Doctor> sl = new ArrayList<Doctor>();

   

    public void testEditDelete() {

        ArrayList<Doctor> sl = new ArrayList<Doctor>();
        Doctor s1 = new Doctor("Nguyen Thi Lan Anh", 12345);
        Doctor s2 = new Doctor("Tran Van Minh", 2);
        Doctor s3 = new Doctor("Nguyen An", 101010);

        sl.add(s1);
        sl.add(s2);
        sl.add(s3);

        DoctorList dtList = new DoctorList();
        dtList.addDoctor(s1);
        dtList.addDoctor(s2);
        dtList.addDoctor(s3);

        // cap nhat thong tin

        System.out.println("Enter doctor ID");
        Scanner doctorID = new Scanner(System.in);

        int s = doctorID.nextInt();

        System.out.println("Enter doctor fullname");

        Scanner fullname = new Scanner(System.in); // Create a Scanner object

        String newName = fullname.nextLine();

        dtList.getEditDoctor(newName, s);

        dtList.printDoctorList();

        System.out.print("test xoa:");

       
        System.out.println("Enter doctor ID");
        Scanner ID = new Scanner(System.in);

        int studentDel = ID.nextInt();
        dtList.getDeleteDoctor(studentDel);
        System.out.print("danh sach sau khi xoa:");
        dtList.printDoctorList();
       
    }

   

}