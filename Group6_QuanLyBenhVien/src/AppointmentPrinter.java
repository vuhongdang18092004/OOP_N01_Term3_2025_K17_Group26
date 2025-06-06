import java.time.format.DateTimeFormatter;
import java.util.List;

public class AppointmentPrinter {

    public static void printAppointmentTable(List<Appointment> appointments) {
        if (appointments == null || appointments.isEmpty()) {
            System.out.println("Không có lịch khám để hiển thị.");
            return;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        
        System.out.printf("%-20s %-20s %-12s %-6s %-10s%n", "Tên bác sĩ", "Tên bệnh nhân", "Ngày", "Giờ", "Phòng");
        System.out.println("----------------------------------------------------------------------");

       
        for (Appointment appt : appointments) {
            System.out.printf("%-20s %-20s %-12s %-6s %-10s%n",
                    appt.getDoctorName(),
                    appt.getPatientName(),
                    appt.getDate().format(dateFormatter),
                    appt.getTime().format(timeFormatter),
                    appt.getRoom());
        }
    }
}