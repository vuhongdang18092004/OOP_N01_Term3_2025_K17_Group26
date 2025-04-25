import java.util.Date;

public abstract class Person {
    String id;
    String fullName;
    String phone;
    String address;
    String gender;
    Date dateOfBirth;

    public Person(String id, String fullName, String phone, String address, String gender, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract String getInfo();
    
    @Override
    public String toString() {
       return fullName + " (" + id + ")"; 
    }
}
