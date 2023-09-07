package com.nctech.bookmyshow.entity;

import lombok.Data;

@Data
public class TicketEntity {
    private Integer id;
    private String movie;
    private String time;
    private Float price;
    private String seatNumber;
    private Integer UserID;
}
