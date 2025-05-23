package test;

import review.*;


import java.time.LocalDate;

public class TestUser {
    public static void run() {
        FullName name = new FullName("Le", "Hoa");
        Identity id = new Identity("ID001");
        User user = new User(name, LocalDate.of(1999, 12, 1), id, "Admin");

        System.out.println("TestUser Output:");
        System.out.println(user.getInfo(id));
    }
}
