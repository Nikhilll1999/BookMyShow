package com.nctech.bookmyshow.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.database.UserDB;
import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.UserRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(UserDTO user) {
        Integer id = user.getId();
     //   int intValue = (id != null) ? id.intValue() : 0;
        user.setId(UserDB.users.size() +1);
        UserDB.users.add(user);
    }

    @Override
    public List<UserDTO> get() {
        return UserDB.users;
    }

    @Override
    public void saveToFile() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try (FileWriter fileWriter = new FileWriter("C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\UserDB.json")) {
                objectMapper.writeValue(fileWriter, UserDB.users);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }));
    }

    @Override
    public List<UserDTO> readFromFiles() {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\UserDB.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            return objectMapper.readValue(fileReader, new TypeReference<List<UserDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void loadData() {
        UserDB.users = readFromFiles();
    }

    @Override
    public List<UserDTO> toArrayList() {
        return UserDB.linkedUsers;
    }
}