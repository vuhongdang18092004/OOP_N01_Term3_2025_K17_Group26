package Method;

public class Parameters {
    static void myMethod(String fname, int age) {
        //cac tham so duoc chi dinh sau te phuong thuc, be trong dau ()
        //co the them bao nhieu tham so tuy thich
        System.out.println(fname + " Sophie is " + age);
    }

    public static void main(String[] args) {
        myMethod("Do ", 10);
        myMethod("Nguyen ", 20);
        myMethod("Tran ", 30);
        //tham so truyen vao phuong thuc goi la doi so; "fname, age" la tham so, "Do, Nguyen, Tran, 10, 20, 30" la doi so

    }
}
