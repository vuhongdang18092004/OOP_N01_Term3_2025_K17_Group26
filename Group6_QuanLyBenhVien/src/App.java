// public class App {
//     public static void main(String[] args) throws Exception {
//     //     // Gọi các test để kiểm tra các chức năng
//     //     System.out.println("Starting tests...");

//     //     // Gọi các phương thức test của từng lớp
//     //     System.out.println("\nRunning TestAdmin...");
//     //     testAdmin.main(args);

//     //     System.out.println("\nRunning TestDoctor...");
//     //     testDoctor.main(args);

//     //     System.out.println("\nRunning TestPatient...");
//     //     testPatient.main(args);

//     //     System.out.println("\nRunning TestWorkSchedule...");
//     //     testWorkSchedule.main(args);

//     //     System.out.println("\nAll tests finished.");

//         // Person p = new Person();
//         // p.setAddress("Ha Noi");
//         // p.displayInfo();


//         // Time t = new Time();
//         // t.setHour(6).setMinute(6).setSecond(6);
//         // System.out.println(t.toString());


//         // Recursion r = new Recursion();
//         // r.factorial(10);
//         // System.out.println(r.n);


//         // testTime testT = new testTime();
//         // System.out.println(null);
        
//     }


    
// }


import test.TestUser;
import test.TestListOfUser;

public class App {
    public static void main(String[] args) {
        System.out.println("---- Running User Test ----");
        TestUser.run();

        System.out.println("\n---- Running ListOfUser Test ----");
        TestListOfUser.run();
    }
}
