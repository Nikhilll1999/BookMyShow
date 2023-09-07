package com.nctech.bookmyshow.database;

import com.nctech.bookmyshow.dto.BookingDTO;
import com.nctech.bookmyshow.dto.UserDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookingDB {
    public static List<BookingDTO> bookings = new LinkedList<>();
    public static List<BookingDTO> linkedUsers = new ArrayList<>(bookings);

}