import java.time.LocalDate;
import java.util.ArrayList;

public class DoctorList {
    ArrayList<Doctor> listDoctor = new ArrayList<>();

    public void addDoctor(Doctor dt) {
        listDoctor.add(dt);
        System.out.println("Doctor added successfully!");
    }

    public void editDoctor(int doctorID, String fullname, String gender, String address, LocalDate dateOfBirth, String phoneNumber) {
        for (Doctor d : listDoctor) {
            if (d.doctorId == doctorID) {
                d.fullname = fullname;
                d.gender = gender;
                d.address = address;
                d.dateOfBirth = dateOfBirth;
                d.phoneNumber = phoneNumber;
                System.out.println("Information updated successfully!");
                return;
            }
        }
        System.out.println("No doctor found with the entered ID.");
    }

    public void deleteDoctor(int doctorID) {
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).doctorId == doctorID) {
                listDoctor.remove(i);
                System.out.println("Doctor deleted successfully!");
                return;
            }
        }
        System.out.println("No doctor found with the entered ID.");
    }

    public void printDoctorList() {
        if (listDoctor.isEmpty()) {
            System.out.println("The doctor list is empty.");
            return;
        }

        System.out.println("\n=== LIST OF DOCTORS ===");
        for (Doctor d : listDoctor) {
            System.out.println("ID: " + d.doctorId +
                    ", Fullname: " + d.fullname +
                    ", Gender: " + d.gender +
                    ", Address: " + d.address +
                    ", Date of birth: " + d.dateOfBirth +
                    ", Phone nimber: " + d.phoneNumber);
        }
        System.out.println("=========================");
    }
}
