
import java.time.LocalDate;

public class User implements PeopleInterface {
    private FullName fullName;
    private LocalDate dateOfBirth;
    private Identity identity;
    private String userRole;

    public User(FullName fullName, LocalDate dateOfBirth, Identity identity, String userRole) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.identity = identity;
        this.userRole = userRole;
    }

    @Override
    public void setInfo(Identity identity) {
        this.identity = identity;
    }

    @Override
    public String getInfo(Identity identity) {
        return "Full Name: " + fullName.getFullName()
            + ", DOB: " + dateOfBirth
            + ", ID: " + identity.getIdNumber()
            + ", Role: " + userRole;
    }

    // Getters
    public FullName getFullName() { return fullName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public Identity getIdentity() { return identity; }
    public String getUserRole() { return userRole; }
}
