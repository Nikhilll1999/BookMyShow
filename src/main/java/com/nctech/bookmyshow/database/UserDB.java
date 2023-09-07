package com.nctech.bookmyshow.database;

import com.nctech.bookmyshow.dto.UserDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDB {
    public static List<UserDTO> users = new LinkedList<>();
    public static List<UserDTO> linkedUsers = new ArrayList<>(users);
}
