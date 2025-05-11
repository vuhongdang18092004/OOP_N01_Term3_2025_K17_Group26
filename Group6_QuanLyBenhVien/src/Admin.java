
public class Admin {
    private String username;
    private String password;

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void manageDoctor() {
        System.out.println("Managing doctor...");
    }

    public void managePatient() {
        System.out.println("Managing patient...");
    }

    public void createAppointment() {
        System.out.println("Creating appointment...");
    }

    public void manageWorkSchedule() {
        System.out.println("Managing work schedule...");
    }
}