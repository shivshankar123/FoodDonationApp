package Data.models;

import org.json.simple.JSONObject;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String role; // "donor" or "recipient"

    public User(String id, String firstName, String lastName, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public JSONObject toJSON() {
        JSONObject userObj = new JSONObject();
        userObj.put("id", id);
        userObj.put("firstName", firstName);
        userObj.put("lastName", lastName);
        userObj.put("password", password);
        userObj.put("role", role);
        return userObj;
    }
}
