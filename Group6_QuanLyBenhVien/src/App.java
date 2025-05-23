public class App {
    public static void main(String[] args) {
        new Patient("P001", "Nguyen Van A", "Hanoi");
        new Patient("P002", "Tran Thi B", "HCMC");
        new Patient("P003", "Le Van C", "Da Nang");

        System.out.println("Danh sach ban dau:");
        Patient.showAllPatients();

        System.out.println("\nChinh sua Nguyen Van A:");
        Patient.editAddressByName("Nguyen Van A", "Hai Phong");

        System.out.println("\nSau khi sua:");
        Patient.showAllPatients();
    }
}