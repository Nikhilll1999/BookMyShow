package com.nctech.bookmyshow.database;

import com.nctech.bookmyshow.dto.TicketDTO;
import com.nctech.bookmyshow.dto.UserDTO;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TicketDB {
    public static List<TicketDTO> tickets = new LinkedList<>();
    public static List<TicketDTO> linkedUsers = new ArrayList<>(tickets);
}
