import java.util.ArrayList;

public class DoctorList {

    ArrayList<Doctor> st = new ArrayList<Doctor>();

    public ArrayList<Doctor> addDoctor(Doctor dt) {

        st.add(dt);
        return st;

    }

    public ArrayList<Doctor> getEditDoctor(String fullname, int dotorID) {

        for (int i = 0; i < st.size(); i++) {

            if (st.get(i).doctorId == dotorID) {

                System.out.print("true");

                st.get(i).fullname = fullname;
            }

        }

        return st;
    }

    public ArrayList<Doctor> getDeleteDoctor(int dotorID) {

        for (int i = 0; i < st.size(); i++) {

            if (st.get(i).doctorId == dotorID) {

                st.remove(i);

            }

        }

        return st;
    }

    public void printDoctorList() {
        int len = st.size();

        for (int i = 0; i < len; i++) {
            System.out.println("Doctor ID: " + st.get(i).doctorId + " Fullnane: " + st.get(i).fullname);

        }

    }
}

 

 