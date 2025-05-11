import java.time.LocalDate;

public class testDoctor {
    public static void main(String[] args) {
        WorkSchedule schedule = new WorkSchedule("Thứ 2 - Thứ 6: 8h - 17h");

        // Tạo đối tượng Doctor
        Doctor doc = new Doctor(
            "D001", 
            "Nguyễn Văn A", 
            "Nam", 
            LocalDate.of(1980, 3, 15),
            "0909123456", 
            "123 Đường ABC, TP.HCM", 
            "Nội tổng quát", 
            schedule, 
            "P101"
        );

        // Kiểm tra thông tin
        System.out.println(doc.getInfo());
        doc.displayInfo();
        doc.viewWorkSchedule();

        // Cập nhật lịch làm việc mới
        WorkSchedule newSchedule = new WorkSchedule("Thứ 2 - Thứ 7: 7h30 - 16h30");
        doc.updateWorkSchedule(newSchedule);
        System.out.println("Đã cập nhật lịch:");
        doc.viewWorkSchedule();
    }
}
