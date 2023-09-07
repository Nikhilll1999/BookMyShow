package com.nctech.bookmyshow.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.database.TheaterDB;
import com.nctech.bookmyshow.database.UserDB;
import com.nctech.bookmyshow.dto.TheaterDTO;
import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.TheaterRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheaterRepositoryImpl implements TheaterRepository {
    @Override
    public void save(TheaterDTO theater){
        TheaterDB.theaterList.add(theater);
    }

    @Override
    public List<TheaterDTO> get() {
        return TheaterDB.theaterList;
    }

    
    public void saveToFile() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try (FileWriter fileWriter = new FileWriter("C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\TheaterDB.json")) {
                objectMapper.writeValue(fileWriter, TheaterDB.theaterList);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }));
    }


    public List<TheaterDTO> readFromFiles() {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\TheaterDB.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            return objectMapper.readValue(fileReader, new TypeReference<List<TheaterDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void loadData() {
        TheaterDB.theaterList = readFromFiles();
    }

    @Override
    public LinkedList<TheaterDTO> toArrayList() {
        return new LinkedList<>(TheaterDB.theaterList);
    }
}
