import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        // Sample user registration for testing (these could be handled via console input too)
        Donor donor = new Donor("donor1", "password123", "donor1@example.com");
        userService.registerUser(donor);
        Recipient recipient = new Recipient("recipient1", "password1234", "recipient1@example.com");
        userService.registerUser(recipient);

        // Main loop for console-based login and actions
        while (true) {
            System.out.println("\n=== Food Donation App ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Login
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Perform login
                User loggedInUser = userService.login(username, password);

                if (loggedInUser != null) {
                    // Once logged in, show the appropriate menu based on the user role
                    if (loggedInUser instanceof Donor) {
                        donorMenu((Donor) loggedInUser, scanner);
                    } else if (loggedInUser instanceof Recipient) {
                        recipientMenu((Recipient) loggedInUser, scanner);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Exiting... Thank you for using the Food Donation App.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Menu for Donor actions
    public static void donorMenu(Donor donor, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Donor Menu ---");
            System.out.println("1. Add Donation");
            System.out.println("2. View Donations");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Add a donation
                System.out.print("Enter food type (e.g., Canned Food): ");
                String donation = scanner.nextLine();
                donor.addDonation(donation);
            } else if (choice == 2) {
                // View donations
                donor.viewDonations();
            } else if (choice == 3) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Menu for Recipient actions
    public static void recipientMenu(Recipient recipient, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Recipient Menu ---");
            System.out.println("1. Claim Donation");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Claim a donation
                System.out.print("Enter the food you want to claim: ");
                String donation = scanner.nextLine();
                recipient.claimDonation(donation);
            } else if (choice == 2) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
