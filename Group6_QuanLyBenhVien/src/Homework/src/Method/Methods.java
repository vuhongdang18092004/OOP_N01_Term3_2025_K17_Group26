package Method;


    //Dung phuong thuc de dinh nghia ma mot lan va tai su dung nhieu lan
    //Mot phuong thuc phai khai bao trong mot lop, dinh nghia bang ten theo sau la dau ()

//Tao mot phuong thuc

public class Methods {
    static void myMethod() { 
        //myMethod() ten phuong thuc
        //static phuong thuc thuoc lop Main, chu khong phai doi tuong cua lop Main
        //void phuong phap nay khong co gia tri tra ve
        //code to be executed
        System.out.println("Hello Happy. How are you today?");

    }

    public static void main(String[] args) {
        myMethod(); 
        //de goi mot phuong thuc, viet ten phuong thuc theo sau la dau ();
        myMethod(); 
        myMethod(); 
        myMethod(); 
        //mot phuong thuc cung co the duoc goi nhieu lan
    }

}
