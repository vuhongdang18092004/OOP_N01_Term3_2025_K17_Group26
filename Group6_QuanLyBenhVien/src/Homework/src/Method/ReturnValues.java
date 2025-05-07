package Method;

public class ReturnValues {
    static int myMethod(int x) {
        return 5 + x;
    }

    static int myMethod1(int a, int b) {
        return a + b;
    }

    static int myMethod2(int m, int n, int p, int q) {
        return m * n + p - q;
    }

    public static void main(String[] args) {
        System.out.println(myMethod(10));
        System.out.println(myMethod1(6, 6));
        //Lưu trữ kết quả trong một biến (dẽ đọc và bảo trì)
        int s = myMethod2(6, 6, 6, 6);
        System.out.println(s);
        
    }
}
