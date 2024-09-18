public class Recipient extends User {

    // constructor
    public Recipient(String username, String password, String contactInfo){
        super(username, password, contactInfo, "Recipient");
    }

    //To claim donation
    public void claimDonation(String donation){
        System.out.println("Donation claimed: " + donation);
    }


}
