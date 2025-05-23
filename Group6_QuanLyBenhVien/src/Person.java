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

public class Person {
    private String id;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;

    // public Person(String id, String name, String gender, LocalDate dateOfBirth, String phone, String address) {
    //     this.id = id;
    //     this.name = name;
    //     this.gender = gender;
    //     this.dateOfBirth = dateOfBirth;
    //     this.phone = phone;
    //     this.address = address;
    // }

    //Get, set id
    public String getId() {
        return id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    //Get, set name
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    //Get, set gender
    public String getGender() {
        return gender;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    //Get dateOfBirh
    public LocalDate getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(LocalDate newdateOfBirth) {
        this.dateOfBirth = newdateOfBirth;
    }

    //Get, set phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
    //Get, set address 
    public String getAddress() {
        return address;
    } 

    public void setAddress(String newAddress) {
        this.address = newAddress;
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


    // public abstract String getInfo();
}
