package Data.Impl;

import Data.Interface.DonationInterface;
import Data.models.Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationImpl implements DonationInterface {
    private List<Donation> donations = new ArrayList<>();

    @Override
    public void registerDonation(Donation donation) {
        donations.add(donation);
        System.out.println("Donation registered successfully.");
    }

    @Override
    public List<Donation> viewAvailableDonations() {
        return donations;
    }

    @Override
    public void claimDonation(String donationId) {
        donations.removeIf(donation -> donation.getDonationId().equals(donationId));
        System.out.println("Donation claimed successfully.");
    }
}
