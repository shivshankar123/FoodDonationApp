package Data.Impl;

import Data.Interface.DonorInterface;
import Data.models.Donor;
import java.util.ArrayList;
import java.util.List;

public class DonorImpl implements DonorInterface {
    private List<Donor> donors;

    public DonorImpl() {
        donors = new ArrayList<>();
    }

    @Override
    public void registerDonor(Donor donor) {
        donors.add(donor);
        System.out.println("Donor registered successfully: " + donor.getFirstName() + " " + donor.getLastName());
    }

    // Optional: Add a method to retrieve all donors
    public List<Donor> getAllDonors() {
        return donors;
    }
}
