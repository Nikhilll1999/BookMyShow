package com.nctech.bookmyshow.entity;

import lombok.Data;

@Data
public class BookingEntity {
    private Integer id;
    private String chosenMovie;
    private String chooseBy;
    private String time;
    private Integer userID;
    private Integer theaterID;
}
