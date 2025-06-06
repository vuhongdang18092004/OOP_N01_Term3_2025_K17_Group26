package manager;

import model.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentManager {
    public static List<Appointment> filterAppointmentsByDate(List<Appointment> appointments, LocalDate date) {
        return appointments.stream()
                .filter(a -> a.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
