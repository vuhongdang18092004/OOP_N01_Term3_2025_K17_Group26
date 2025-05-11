public class testAppointment {
    public static void main(String[] args) {
        // Tạo đối tượng Appointment
        Appointment appt = new Appointment("2025-05-15", "08:30", "Nguyễn Văn A");

        // Kiểm tra kết quả toString
        System.out.println(appt);
    }
}