package Method;

public class Overloading {
    //Nhiều phương thức có thể có cùng tên với các tham số khác nhau
    /*
     * int myMethod(int x)
     * float myMethod(float x)
     * double myMethod(double x, double y)
     * Thay vì định nghĩa hai phương thức có tên giống nhau, nên quá tải (nạp chồng) một phương thức
     * Dùng plusMethod để sử dụng cho int và double 
     * thay vì dùng plusMethodInt cho int, plusMethodDouble cho double
     *
     */
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        int myNum1 = plusMethod(6, 8);
        double myNum2 = plusMethod(6.6, 8.8);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);
    }



}
