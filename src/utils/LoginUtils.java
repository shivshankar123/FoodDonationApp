package utils;

import Data.models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginUtils {
    private final String USER_FILE = "src/users.json"; // Adjust this path based on your project structure

    public void registerUser(User user) {
        try {
            JSONArray userList = readUsersFromFile();
            userList.add(user.toJSON());
            writeUsersToFile(userList);
            System.out.println("User registered successfully.");
        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("Error during user registration: " + e.getMessage());
        }
    }

    public User login(String firstName, String password) {
        try {
            JSONArray userList = readUsersFromFile();
            for (Object obj : userList) {
                JSONObject jsonUser = (JSONObject) obj;
                String role = (String) jsonUser.get("role");

                if (role.equals("donor")) {
                    // Donor login requires both first name and password
                    if (jsonUser.get("firstName").equals(firstName) && jsonUser.get("password").equals(password)) {
                        return new User(
                                (String) jsonUser.get("id"),
                                (String) jsonUser.get("firstName"),
                                (String) jsonUser.get("lastName"),
                                (String) jsonUser.get("password"),
                                role
                        );
                    }
                } else if (role.equals("recipient")) {
                    // Recipient login requires only the first name
                    if (jsonUser.get("firstName").equals(firstName)) {
                        return new User(
                                (String) jsonUser.get("id"),
                                (String) jsonUser.get("firstName"),
                                (String) jsonUser.get("lastName"),
                                null,  // Recipients don’t need passwords
                                role
                        );
                    }
                }
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        return null;
    }

    private JSONArray readUsersFromFile() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        File file = new File(USER_FILE);

        if (!file.exists()) {
            file.createNewFile();  // Create the file if it doesn't exist
            writeUsersToFile(new JSONArray()); // Initialize with an empty JSON array
        }

        FileReader reader = new FileReader(file);
        return (JSONArray) jsonParser.parse(reader);
    }

    private void writeUsersToFile(JSONArray userList) throws IOException {
        FileWriter fileWriter = new FileWriter(USER_FILE);
        fileWriter.write(userList.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
