package com.nctech.bookmyshow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheaterEntity {
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer noOfScreens;
    private Integer userID;
}
