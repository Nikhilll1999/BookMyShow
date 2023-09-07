package com.nctech.bookmyshow.entity;

import lombok.Data;

@Data
public class ShowEntity {
    private Integer id;
    private String name;
    private String genre;
    private String rating;
    private String description;
}
