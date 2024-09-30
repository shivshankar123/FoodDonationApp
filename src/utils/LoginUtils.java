package utils;

import Data.models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginUtils {
    private final String USER_FILE = "../users.json";

    public void registerUser(User user) {
        try {
            JSONArray userList = readUsersFromFile();
            userList.add(user.toJSON());
            writeUsersToFile(userList);
            System.out.println("User registered successfully.");
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public User login(String firstName, String password) {
        try {
            JSONArray userList = readUsersFromFile();
            for (Object obj : userList) {
                JSONObject jsonUser = (JSONObject) obj;
                if (jsonUser.get("firstName").equals(firstName) && jsonUser.get("password").equals(password)) {
                    return new User((String) jsonUser.get("id"),
                            (String) jsonUser.get("firstName"),
                            (String) jsonUser.get("lastName"),
                            (String) jsonUser.get("password"),
                            (String) jsonUser.get("role"));
                }
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONArray readUsersFromFile() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(USER_FILE);
        return (JSONArray) jsonParser.parse(reader);
    }

    private void writeUsersToFile(JSONArray userList) throws IOException {
        FileWriter fileWriter = new FileWriter(USER_FILE);
        fileWriter.write(userList.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
