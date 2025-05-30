import java.util.Date;

// Lớp Appointment (giả định để hoàn thiện cấu trúc)
public class Appointment {
    private Date appointmentTime;
    private String status;

    public Appointment(Date appointmentTime, String status) {
        this.appointmentTime = appointmentTime;
        this.status = status;
    }
}