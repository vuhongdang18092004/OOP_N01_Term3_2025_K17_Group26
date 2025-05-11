
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String medicalHistory;
    private List<Appointment> appointments = new ArrayList<>(); 

    public Patient(String id, String name, String gender, LocalDate dateOfBirth,
                   String phone, String address, String medicalHistory) {
        super(id, name, gender, dateOfBirth, phone, address);
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String getInfo() {
        return "Patient: " + name + ", Phone: " + phone + ", Address: " + address +
               ", Medical History: " + medicalHistory;
    }

    public void addAppointment(Appointment appt) {
        appointments.add(appt);  // Thêm cuộc hẹn vào danh sách
    }

    public void cancelAppointment(Appointment appt) {
        appointments.remove(appt);  // Xóa cuộc hẹn khỏi danh sách
    }

    public void viewAppointmentHistory() {
        for (Appointment appt : appointments) {
            System.out.println(appt);  // Hiển thị tất cả các cuộc hẹn
        }
    }
}
