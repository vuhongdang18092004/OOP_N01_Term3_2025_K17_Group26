package util;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHelper {
    public static LocalDate inputDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày (yyyy-mm-dd): ");
        return LocalDate.parse(scanner.nextLine());
    }
}
