package com.nctech.bookmyshow.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nctech.bookmyshow.constants.Constants;
import com.nctech.bookmyshow.database.BookingDB;
import com.nctech.bookmyshow.dto.BookingDTO;
import com.nctech.bookmyshow.repositories.BookingRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the {@link BookingRepository} interface that provides methods to interact with the booking data.
 */
public class BookingRepositoryImpl implements BookingRepository {

    /**
     * Saves a booking to the repository.
     *
     * @param booking the booking to be saved
     */
    public void save(BookingDTO booking) {
        BookingDB.bookings.add(booking);
    }

    /**
     * Retrieves all the bookings from the repository.
     *
     * @return a list of all the bookings
     */
    public List<BookingDTO> get() {
        return BookingDB.bookings;
    }

    /**
     * Saves the booking data to a file.
     */
    public void saveToFile() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();

            try (FileWriter fileWriter = new FileWriter(Constants.FilePath.BOOKINGDBPATH)) {
                objectMapper.writeValue(fileWriter, BookingDB.bookings);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }));
    }

    /**
     * Reads the booking data from a file.
     *
     * @return a list of booking data
     */
    public List<BookingDTO> readFromFiles() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (FileReader fileReader = new FileReader(Constants.FilePath.BOOKINGDBPATH)) {
            return objectMapper.readValue(fileReader, new TypeReference<List<BookingDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Loads the booking data into the repository.
     */
    public void loadData() {
        BookingDB.bookings = readFromFiles();
    }

    /**
     * Converts the booking data to a linked list.
     *
     * @return a linked list of booking data
     */
    public LinkedList<BookingDTO> toArrayList() {
        return new LinkedList<>(BookingDB.bookings);
    }
}
