
public class testAdmin {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.changePassword("admin123"); 

        System.out.println("Test login with correct credentials:");
        boolean loginSuccess = admin.login("admin", "admin123");
        System.out.println("Login success: " + loginSuccess); //true

        System.out.println("\nTest login with incorrect credentials:");
        loginSuccess = admin.login("admin", "wrongpassword");
        System.out.println("Login success: " + loginSuccess); //false

        System.out.println("\nTest managing doctor:");
        admin.manageDoctor();

        System.out.println("\nTest managing patient:");
        admin.managePatient();

        System.out.println("\nTest creating appointment:");
        admin.createAppointment();

        System.out.println("\nTest managing work schedule:");
        admin.manageWorkSchedule(); 

        // Thử thay đổi mật khẩu và kiểm tra lại login
        admin.changePassword("newpassword");
        System.out.println("\nTest login with new password:");
        loginSuccess = admin.login("admin", "newpassword");
        System.out.println("Login success: " + loginSuccess); 
    }
}
