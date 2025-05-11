// import java.util.Date;

// public abstract class Person {
//     String id;
//     String fullName;
//     String phone;
//     String address;
//     String gender;
//     Date dateOfBirth;

//     public Person(String id, String fullName, String phone, String address, String gender, Date dateOfBirth) {
//         this.id = id;
//         this.fullName = fullName;
//         this.phone = phone;
//         this.address = address;
//         this.gender = gender;
//         this.dateOfBirth = dateOfBirth;
//     }

//     public abstract String getInfo();
    
//     @Override
//     public String toString() {
//        return fullName + " (" + id + ")"; 
//     }
// }


import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    protected String id;
    protected String name;
    protected String gender;
    protected LocalDate dateOfBirth;
    protected String phone;
    protected String address;

    public Person(String id, String name, String gender, LocalDate dateOfBirth, String phone, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }

    public void updateContactInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }


    public abstract String getInfo();
}
