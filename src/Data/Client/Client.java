package Data.Client;

import Data.Impl.DonationImpl;
import Data.Impl.DonorImpl;
import Data.Impl.RecipientImpl;
import Data.Interface.DonorInterface;
import Data.Interface.DonationInterface;
import Data.Interface.RecipientInterface;
import Data.models.Donation;
import Data.models.Donor;
import Data.models.Recipient;
import Data.models.User;
import utils.LoginUtils;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DonationInterface donationService = new DonationImpl();
        DonorInterface donorService = new DonorImpl();
        RecipientInterface recipientService = new RecipientImpl();
        LoginUtils loginUtils = new LoginUtils();

        System.out.println("Welcome to Food Donation App!");
        System.out.println("1. Register as Donor");
        System.out.println("2. Register as Recipient");
        System.out.println("3. Login");
        System.out.println("4. Exit");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter ID:");
                    String donorId = scanner.nextLine();
                    System.out.println("Enter First Name:");
                    String donorFirstName = scanner.nextLine();
                    System.out.println("Enter Last Name:");
                    String donorLastName = scanner.nextLine();
                    System.out.println("Enter Address:");
                    String donorAddress = scanner.nextLine();
                    System.out.println("Enter Phone Number:");
                    String donorPhoneNumber = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String donorPassword = scanner.nextLine();
                    donorService.registerDonor(new Donor(donorId, donorFirstName, donorLastName, donorAddress, donorPhoneNumber, donorPassword));
                    loginUtils.registerUser(new User(donorId, donorFirstName, donorLastName, donorPassword, "donor"));
                    break;

                case 2:
                    System.out.println("Enter ID:");
                    String recipientId = scanner.nextLine();
                    System.out.println("Enter Name:");
                    String recipientName = scanner.nextLine();
                    System.out.println("Enter Contact Info:");
                    String recipientContactInfo = scanner.nextLine();
                    recipientService.registerRecipient(new Recipient(recipientId, recipientName, recipientContactInfo));
                    loginUtils.registerUser(new User(recipientId, recipientName, "", null, "recipient"));
                    break;

                case 3:
                    System.out.println("Enter First Name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Are you a donor or recipient?");
                    String role = scanner.nextLine().toLowerCase();  // Get user role

                    String password = null;
                    if (role.equals("donor")) {
                        // Ask for a password if the user is a donor
                        System.out.println("Enter Password:");
                        password = scanner.nextLine();
                    }

                    // Call the login method with the first name and password (password can be null for recipients)
                    User user = loginUtils.login(firstName, password);

                    if (user != null) {
                        System.out.println("Login successful! Role: " + user.getRole());
                        if (user.getRole().equals("donor")) {
                            // Donor functionalities (like registering donation)
                            System.out.println("Enter Donation ID:");
                            String donationId = scanner.nextLine();
                            System.out.println("Enter Food Type:");
                            String foodType = scanner.nextLine();
                            System.out.println("Enter Quantity:");
                            double quantity = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            System.out.println("Enter Unit:");
                            String unit = scanner.nextLine();
                            System.out.println("Enter Expiration Date:");
                            String expirationDate = scanner.nextLine();
                            donationService.registerDonation(new Donation(donationId, user.getId(), foodType, quantity, unit, expirationDate));
                        } else {
                            // Recipient functionalities
                            System.out.println("Available Donations:");
                            donationService.viewAvailableDonations().forEach(donation -> {
                                System.out.println("Donation ID: " + donation.getDonationId() + ", Food Type: " + donation.getFoodType());
                            });
                        }
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
