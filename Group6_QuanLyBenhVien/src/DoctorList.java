import java.util.ArrayList;

public class DoctorList {

    ArrayList<Doctor> dt = new ArrayList<Doctor>();

    public ArrayList<Doctor> addDoctor(Doctor dt) {

        dt.add(dt);
        return dt;

    }

    public ArrayList<Doctor> getEditDoctor(String fullname, int dotorID) {

        for (int i = 0; i < dt.size(); i++) {

            if (dt.get(i).doctorId == dotorID) {

                System.out.print("true");

                dt.get(i).fullname = fullname;
            }

        }

        return dt;
    }

    public ArrayList<Doctor> getDeleteDoctor(int dotorID) {

        for (int i = 0; i < dt.size(); i++) {

            if (dt.get(i).doctorId == dotorID) {

                dt.remove(i);

            }

        }

        return dt;
    }

    public void printDoctorList() {
        int len = dt.size();

        for (int i = 0; i < len; i++) {
            System.out.println("Doctor ID: " + dt.get(i).doctorId + " Fullnane: " + dt.get(i).fullname);

        }

    }
}

 

 