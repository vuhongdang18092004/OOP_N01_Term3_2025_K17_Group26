import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment("BS. An", "Nguyễn Văn A", LocalDate.of(2025, 6, 6), LocalTime.of(9, 30), "P101"));
        appointments.add(new Appointment("BS. Bình", "Trần Thị B", LocalDate.of(2025, 6, 7), LocalTime.of(10, 0), "P102"));
        appointments.add(new Appointment("BS. An", "Phạm Văn C", LocalDate.of(2025, 6, 6), LocalTime.of(11, 15), "P101"));

        LocalDate selectedDate = InputHelper.inputDate();

        List<Appointment> filtered = AppointmentManager.filterAppointmentsByDate(appointments, selectedDate);

        if (filtered.isEmpty()) {
            System.out.println("Không có lịch khám trong ngày đã chọn.");
        } else {
            System.out.println("Danh sách lịch khám trong ngày " + selectedDate + ":");
            AppointmentPrinter.printAppointmentTable(filtered);
        }
    }
}