package com.nctech.bookmyshow.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.database.ShowDB;
import com.nctech.bookmyshow.dto.ShowDTO;
import com.nctech.bookmyshow.repositories.ShowRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShowRepositoryImpl implements ShowRepository {
    public void save(ShowDTO show) {
        ShowDB.shows.add(show);
    }

    public List<ShowDTO> get() {
        return ShowDB.shows;
    }

    public void saveToFile() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try (FileWriter fileWriter = new FileWriter("C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\ShowDB.json")) {
                objectMapper.writeValue(fileWriter, ShowDB.shows);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }));
    }


    public List<ShowDTO> readFromFiles() {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\ShowDB.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            return objectMapper.readValue(fileReader, new TypeReference<List<ShowDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void loadData() {
        ShowDB.shows = readFromFiles();
    }

    @Override
    public LinkedList<ShowDTO> toArrayList() {
        return new LinkedList<>(ShowDB.shows);
    }
}
