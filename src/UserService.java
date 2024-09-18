import java.util.ArrayList;
import java.util.List;
public class UserService {

    private List<User> users;

    // constructor
    public UserService(){
        users = new ArrayList<>(); // Initialize an empty list of Users
    }

    public void registerUser( User user){
        if (validateUsername(user.getUsername()) && validatePassword(user.getPassword())){
            users.add(user);
            System.out.println("User registered successfully: " + user.getUsername());
        }

    }
    private boolean validateUsername(String username){
        if (username.length()<5){
            System.out.println("Username must be at least 5 character long.");
            return false;
        }
        for (User user:users){
            if (user.getUsername(). equals(username)){
                System.out.println("Username already exists. please choose a different one.");
                return false;
            }
        }
        return true;
    }

    private boolean validatePassword(String password){
        if (password.length() < 8){
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
        return true;

    }
    // Login method
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + username);
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    // Method to display all registered users (for testing)
    public void displayAllUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            user.displayUserInfo();
            System.out.println();
        }
    }


}
