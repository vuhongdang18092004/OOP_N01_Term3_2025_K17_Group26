// package review;

import java.util.ArrayList;
import java.util.List;

public class Doctor implements Entity {
    private int doctorId;
    private String fullName;
    private String gender;
    private String dob;
    private String department;
    private List<Appointment> appointments;

    public Doctor(int doctorId, String fullName, String gender, String dob, String department) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
        this.appointments = new ArrayList<>();
    }

    @Override
    public int getId() {
        return doctorId;
    }

    @Override
    public void setId(int id) {
        this.doctorId = id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public byte[] toBinary() {
        try {
            return this.toString().getBytes();
        } catch (Exception e) {
            System.err.println("Error converting to binary: " + e.getMessage());
            return new byte[0];
        }
    }

    // Getters and Setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    // Appointment management methods
    public void addAppointment(Appointment appointment) {
        try {
            if (appointment == null) {
                throw new IllegalArgumentException("Appointment cannot be null");
            }
            appointments.add(appointment);
        } catch (Exception e) {
            System.err.println("Error adding appointment: " + e.getMessage());
        }
    }

    public void removeAppointment(Appointment appointment) {
        try {
            if (appointment == null) {
                throw new IllegalArgumentException("Appointment cannot be null");
            }
            appointments.remove(appointment);
        } catch (Exception e) {
            System.err.println("Error removing appointment: " + e.getMessage());
        }
    }

    public void updateInfo(String fullName, String gender, String dob) {
        try {
            setFullName(fullName);
            setGender(gender);
            setDob(dob);
        } catch (Exception e) {
            System.err.println("Error updating doctor info: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ID: " + doctorId + ", Full Name: " + fullName + ", Gender: " + gender + ", DOB: " + dob + ", Department: " + department;
    }
}
