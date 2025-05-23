package test;

import src.*;
import java.time.LocalDate;

public class TestListOfUser {
    public static void run() {
        ListOfUser list = new ListOfUser();
        list.addUser(new User(new FullName("Nguyen", "An"), LocalDate.of(1995, 5, 15), new Identity("ID123"), "Doctor"));
        list.addUser(new User(new FullName("Tran", "Binh"), LocalDate.of(2000, 8, 20), new Identity("ID456"), "Nurse"));

        System.out.println("TestListOfUser Output:");
        for (User user : list.getUsers()) {
            System.out.println(user.getInfo(user.getIdentity()));
        }
    }
}
