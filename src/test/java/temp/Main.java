package temp;

import com.google.gson.Gson;
import com.nctech.bookmyshow.constants.Constants;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        Add(userDTO);
    }
    public static void Add(UserDTO user) {
        // Convert UserDTO object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Write JSON to a file
        String filePath =  Constants.FilePath.USERDBPATH +"UserDB.json";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
