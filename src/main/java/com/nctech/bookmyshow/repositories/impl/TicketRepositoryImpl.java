package com.nctech.bookmyshow.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.database.TicketDB;
import com.nctech.bookmyshow.database.UserDB;
import com.nctech.bookmyshow.dto.TicketDTO;
import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.repositories.TicketRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    public void save(TicketDTO ticket) {
        TicketDB.tickets.add(ticket);
    }

    public List<TicketDTO> get() {
        return TicketDB.tickets;
    }

    public void saveToFile() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try (FileWriter fileWriter = new FileWriter("C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\TicketDB.json")) {
                objectMapper.writeValue(fileWriter, TicketDB.tickets);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }));
    }


    public List<TicketDTO> readFromFiles() {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "C:\\Abhi\\My Code\\My Projects\\BookMyShow\\src\\main\\java\\com\\nctech\\bookmyshow\\database\\file\\TicketDB.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            return objectMapper.readValue(fileReader, new TypeReference<List<TicketDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void loadData() {
        TicketDB.tickets = readFromFiles();
    }

    @Override
    public LinkedList<TicketDTO> toArrayList() {
        return new LinkedList<>(TicketDB.tickets);
    }
}
