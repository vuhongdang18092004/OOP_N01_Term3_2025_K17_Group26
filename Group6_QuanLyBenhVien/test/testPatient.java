import java.time.LocalDate;

public class testPatient {
    public static void main(String[] args) {
        //bệnh nhân mới
        Patient patient = new Patient(
                "P001",
                "Trần Thị B",
                "Nữ",
                LocalDate.of(1995, 5, 20),
                "0988123456",
                "456 Đường XYZ, Hà Nội",
                "Tiểu đường");

        //vài cuộc hẹn mẫu
        Appointment appt1 = new Appointment("2025-05-12", "09:00", "Nguyễn Văn A");
        Appointment appt2 = new Appointment("2025-06-10", "14:00", "Lê Thị B");

        // Thêm cuộc hẹn
        patient.addAppointment(appt1);
        patient.addAppointment(appt2);

        // Hiển thị thông tin và lịch sử cuộc hẹn
        System.out.println(patient.getInfo());
        System.out.println("Lịch sử cuộc hẹn:");
        patient.viewAppointmentHistory();

        // Hủy một cuộc hẹn
        patient.cancelAppointment(appt1);
        System.out.println("\nSau khi hủy 1 cuộc hẹn:");
        patient.viewAppointmentHistory();
    }
}