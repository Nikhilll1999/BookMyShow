package temp;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling2 {
    public static void main(String[] args) {
        // Create a UserDTO object
        UserDTO user = new UserDTO("John Doe", "johndoe@example.com");

        // Convert UserDTO object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(user);

        // Write JSON to a file
        String filePath = "user.json";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
            System.out.println("User data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserDTO {
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters (not necessary for this example)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


