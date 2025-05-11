
public class Appointment {
    private String date;
    private String time;
    private String doctor;

    public Appointment(String date, String time, String doctor) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment with Dr. " + doctor + " on " + date + " at " + time;
    }
}
