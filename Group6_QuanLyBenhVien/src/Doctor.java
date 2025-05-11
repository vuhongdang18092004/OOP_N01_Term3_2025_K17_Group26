
import java.time.LocalDate;

public class Doctor extends Person {
    private String specialty;
    private WorkSchedule workSchedule; 
    private String officeNumber;

    // Constructor của Doctor
    public Doctor(String id, String name, String gender, LocalDate dateOfBirth, String phone, 
                  String address, String specialty, WorkSchedule workSchedule, String officeNumber) {
        super(id, name, gender, dateOfBirth, phone, address); // Gọi constructor của lớp Person
        this.specialty = specialty;
        this.workSchedule = workSchedule;
        this.officeNumber = officeNumber;
    }

    @Override
    public String getInfo() {
        return "Doctor: " + name + ", Specialty: " + specialty + ", Office: " + officeNumber;
    }

    // Các phương thức khác của Doctor
    public void updateWorkSchedule(WorkSchedule newSchedule) {
        this.workSchedule = newSchedule;
    }

    public void viewWorkSchedule() {
        System.out.println("Work schedule: " + workSchedule);
    }
}
