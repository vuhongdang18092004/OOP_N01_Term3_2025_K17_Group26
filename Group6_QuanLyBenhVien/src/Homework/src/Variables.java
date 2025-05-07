// type variableName = value;
public class Variables {
    public static void main(String[] args) {
        int Num = 5;
        //Num = 10; Khi nay Num 10 chu khong phai 5 (ghi de)
        //Dung bien "final" hoac "constant" neu khong muon ghi de len gia tri hien co
        // final int Num = 20;
        // Num = 22 (chuong trinh se bao loi)
        float FloatNum = 9.9f;
        char Letter = 'H';
        boolean Bool = true;
        String Text = "Hello";


        //Hien thi bien

        String name = "Hanh";
        String firstName = "Do Thi ";
        String lastName = "My Hanh";
        String fullName = firstName + lastName;
        int x = 10;
        int y = 6;


        //Khai bao nhieu bien
        int a = 10, b = 6, c = 6;

        //Mot gia tri cho nhieu bien
        int m, n, k;
        m = n = k = 10;


        //Examples
        //Student data
        String studentName = "Do Thi My Hanh";
        int studentID = 22010128;
        int studentAge = 22;
        char studentGrade = 'A';

        //Calculate the area of a rectangle
        int length = 6;
        int width = 8;
        int area;
        area = length * width;


        
        //Khai bao bien
        System.out.println(Num);
        System.out.println(FloatNum);
        System.out.println(Letter);
        System.out.println(Bool);
        System.out.println(Text);

        //Khai bao nhieu bien
        System.out.println("Hello " + name);
        System.out.println(fullName);
        System.out.println(x + y);
        System.out.println(a + b + c);
        System.out.println(m + n + k);


        //Student data
        System.out.println("Student name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Student age: " + studentAge);
        System.out.println("Student grade: " + studentGrade);


        //Calculate the area of a rectangle
        System.out.println("Length is: " + length);
        System.out.println("Width is: " + width);
        System.out.println("Area is: " + area);

    }
    
}




