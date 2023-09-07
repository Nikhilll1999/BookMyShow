package com.nctech.bookmyshow.database;

import com.nctech.bookmyshow.dto.ShowDTO;
import com.nctech.bookmyshow.dto.UserDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShowDB {
    public static List<ShowDTO> shows = new LinkedList<>();
    public static List<ShowDTO> linkedUsers = new ArrayList<>(shows);

}
