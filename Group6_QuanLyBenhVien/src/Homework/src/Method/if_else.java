package Method;

public class if_else {
    static void checkAge(int age) {
        if(age < 18) {
            System.out.println("Tuoi cua ban la: " + age + " - Ban chua du tuoi!");
        }

        else {
            System.out.println("Tuoi cua ban la: " + age + " - Ban da du tuoi!");
        }
    }
    public static void main(String[] args) {
        checkAge(20);
        checkAge(16);

    }
}