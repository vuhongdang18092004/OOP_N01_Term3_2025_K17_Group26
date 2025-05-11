public class App {
    public static void main(String[] args) throws Exception {
        // Gọi các test để kiểm tra các chức năng
        System.out.println("Starting tests...");

        // Gọi các phương thức test của từng lớp
        System.out.println("\nRunning TestAdmin...");
        testAdmin.main(args);

        System.out.println("\nRunning TestDoctor...");
        testDoctor.main(args);

        System.out.println("\nRunning TestPatient...");
        testPatient.main(args);

        System.out.println("\nRunning TestWorkSchedule...");
        testWorkSchedule.main(args);

        System.out.println("\nAll tests finished.");
    }
}
