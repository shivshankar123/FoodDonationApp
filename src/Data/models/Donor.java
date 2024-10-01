package Data.models;

public class Donor extends User {
    private String address;
    private String phoneNumber;

    // Updated constructor to include password
    public Donor(String id, String firstName, String lastName, String address, String phoneNumber, String password) {
        super(id, firstName, lastName, password, "donor");
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters (if needed)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                "} " + super.toString();
    }
}
