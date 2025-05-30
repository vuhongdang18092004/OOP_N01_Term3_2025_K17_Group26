// package review;

public interface Entity {
    int getId();
    void setId(int id);
    String getFullName();
    void setFullName(String fullName);
    byte[] toBinary();
    static Entity fromBinary(byte[] data) {
        try {
            // Placeholder implementation, actual deserialization needed
            return null;
        } catch (Exception e) {
            System.err.println("Error converting from binary: " + e.getMessage());
            return null;
        }
    }
}