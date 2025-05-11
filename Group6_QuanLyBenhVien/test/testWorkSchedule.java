public class testWorkSchedule {
    public static void main(String[] args) {
        //lịch làm việc mới
        WorkSchedule schedule = new WorkSchedule("Thứ 2 - Thứ 6: 8h - 17h");

        // Kiểm tra
        System.out.println("Lịch làm việc ban đầu: " + schedule.toString());

        // Cập nhật
        WorkSchedule newSchedule = new WorkSchedule("Thứ 2 - Thứ 7: 7h30 - 16h30");
        System.out.println("Lịch làm việc đã cập nhật: " + newSchedule.toString());
    }
}
