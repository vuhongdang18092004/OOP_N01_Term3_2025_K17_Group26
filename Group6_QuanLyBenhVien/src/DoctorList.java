import java.util.ArrayList;

public class DoctorList {

    ArrayList<Doctor> listDoctor = new ArrayList<Doctor>();

    public ArrayList<Doctor> addDoctor(Doctor dt) {

        listDoctor.add(dt);
        
        return listDoctor;

    

    }

    public ArrayList<Doctor> getEditDoctor(String fullname, int dotorID) {

        for (int i = 0; i < listDoctor.size(); i++) {

            if (listDoctor.get(i).doctorId == dotorID) {

                System.out.print("true");

                listDoctor.get(i).fullname = fullname;
            }

        }

        return listDoctor;
    }

    public ArrayList<Doctor> getDeleteDoctor(int dotorID) {

        for (int i = 0; i < listDoctor.size(); i++) {

            if (listDoctor.get(i).doctorId == dotorID) {

                listDoctor.remove(i);

            }

        }

        return listDoctor;
    }

    public void printDoctorList() {
        int len = listDoctor.size();

        for (int i = 0; i < len; i++) {
            System.out.println("Doctor ID: " + listDoctor.get(i).doctorId + " Fullnane: " + listDoctor.get(i).fullname);

        }

    }
}

 

 