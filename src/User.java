public class User {

    private String username;
    private String password;
    private String contactInfo;
    private String role;


    // Creating constructor to initialize the User Object

    public User(String username, String password, String contactInfo, String role ){
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.role = role;

    }

    // Creating getters and Setters for encaspulation
    public String getUsername(){
        return username;
    }

    public void setUsername(){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(){
        this.password = password;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //Creating method to display User Information
    public void displayUserInfo(){
        System.out.println("Username: " + username);
        System.out.println("ContactInfo: " + contactInfo);
        System.out.println("Role: " + role);

    }
}
