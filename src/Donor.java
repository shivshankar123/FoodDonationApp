import java.util.ArrayList;
import java.util.List;
public class Donor extends User {
    private List<String> donations;


    //constructor
    public Donor(String username, String password, String contactInfo){
        super(username, password, contactInfo, "Donor");
        this.donations = new ArrayList<>();
    }

    // Method to Add a donation
    public void addDonation(String donation){
        donations.add(donation);
        System.out.println("Donataion add: " + donation);

    }

    // Method to display all donations
    public void viewDonations(){
        System.out.println("Donations by " + getUsername() + ":");
        for (String donation : donations){
            System.out.println(donation);
        }
    }

}
