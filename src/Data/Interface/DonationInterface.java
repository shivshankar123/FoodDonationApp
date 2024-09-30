package Data.Interface;

import Data.models.Donation;

import java.util.List;

public interface DonationInterface {
    void registerDonation(Donation donation);
    List<Donation> viewAvailableDonations();
    void claimDonation(String donationId);
}
