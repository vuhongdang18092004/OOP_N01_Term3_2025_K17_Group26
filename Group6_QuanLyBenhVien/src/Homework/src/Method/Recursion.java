package Method;

public class Recursion {
    /*ĐỆ QUY là kỹ thuật thực hiện lệnh gọi hàm, chia nhỏ các vấn đề phức tạp để đơn giản và dễ giải quyết */
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
    }


    public static int sum(int k) {
        if (k < 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }
}
 // ĐIỀU KIỆN DỪNG
 /*public class Main {
    public static void main(String[] args) {
        int result = sum(5, 10);
        System.out.println(result);
    }
    public static int sum(int start, int end) {
        if (end > start) {
            return end + sum(start, end - 1)
        } else {
            return end;
        }
    }
 }*/