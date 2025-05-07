public class DataTypes {
    public static void main(String[] args) {

        //kieu du lieu nguyen thuy bat dau bang 1 chu cai thuong (vd: int,...) khong the su dung de goi cac phuong thuc, luon giu mot gia tri
        //kieu du lieu khong nguyen thuy bat dau bang chu in hoa (vd: String, Array, Class,...) co the dung de goi cach phuong thuc, co the NULL

        //Du lieu kieu so

        int Num = 10; //integer
        float FloatNum = 9.9f; //float co do chinh xac khoang 6 hoac 7 chu so thap phan
        double DoubleNum = 9.99d; //double co do chinh xac khoang 16 chu so thap phan nen dung cho cac phep tinh
        char Letter = 'H';  //character
        boolean Bool = true; //boolean
        String Text = "Hello"; //string
        byte ByteNum = 100;
        short ShortNum = 5000;
        long LongNum = 15000000000L; //su dung khi int khong du lon

        //so khoa hoc
        float f1 = 35e3f;
        double d1 = 12E4d;


        //Du lieu kieu boolean
        boolean isJavaFun = true;
        boolean isFishTasty = false;


        //Du lieu kieu char
        char Grade = 'H';
        char Var1 = 65, Var2 = 66, Var3 = 67;


        //Du lieu kieu string
        String greeting = "Hello Happy";



        //Example
        //To calculate and output the total cost of a number of items
        int items = 60;
        float costPerItem = 9.99f;
        float totalCost = items * costPerItem;
        char currency = '$';





        //In ra gia tri
        //Du lieu kieu so
        System.out.println(Num);
        System.out.println(FloatNum);
        System.out.println(DoubleNum);
        System.out.println(Letter);
        System.out.println(Bool);
        System.out.println(Text);
        System.out.println(ByteNum);
        System.out.println(ShortNum);
        System.out.println(LongNum);
        System.out.println(f1);
        System.out.println(d1);


        //Du lieu kieu boolean
        System.out.println(isJavaFun);
        System.out.println(isFishTasty);


        //Du lieu kieu char
        System.out.println(Grade);
        System.out.println(Var1);
        System.out.println(Var2);
        System.out.println(Var3);


        //Du lieu kieu string
        System.out.println(greeting);
        

        //Example
        //Print variables
        System.out.println("Number of items: " + items);
        System.out.println("Cost per item: " + costPerItem + currency);
        System.out.println("Total cost: " + totalCost + currency); 

    }
}
