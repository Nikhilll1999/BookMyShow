package com.nctech.bookmyshow.database;

import com.nctech.bookmyshow.dto.TheaterDTO;
import com.nctech.bookmyshow.dto.UserDTO;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheaterDB {
    public static List<TheaterDTO> theaterList = new LinkedList<>();
    public static List<TheaterDTO> linkedUsers = new ArrayList<>(theaterList);
}
