import java.util.ArrayList;

public class Patient {
    private String id;
    private String name;
    private String address;

    private static ArrayList<Patient> patientList = new ArrayList<>();

    public Patient(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        patientList.add(this);
    }

    public String getInfo() {
        return "Patient ID: " + id + ", Name: " + name + ", Address: " + address;
    }

    public String getName() {
        return name;
    }

    public void editAddress(String newAddress) {
        this.address = newAddress;
    }


    public static void showAllPatients() {
        for (Patient p : patientList) {
            System.out.println(p.getInfo());
        }
    }

    public static Patient findPatientByName(String name) {
        for (Patient p : patientList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static boolean editAddressByName(String name, String newAddress) {
        Patient p = findPatientByName(name);
        if (p != null) {
            p.editAddress(newAddress);
            return true;
        }
        return false;
    }
}
