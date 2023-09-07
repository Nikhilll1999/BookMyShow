package com.nctech.bookmyshow.dto;

public class TheaterDTO {
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer noOfScreens;
    private Integer userID;

    public TheaterDTO(){

    }

    public TheaterDTO(Integer id, String name, String location, Integer capacity, Integer noOfScreens, Integer userID ) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.noOfScreens = noOfScreens;
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(int noOfScreens) {
        this.noOfScreens = noOfScreens;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "TheaterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", noOfScreens=" + noOfScreens +
                ", userID=" + userID +
                '}';
    }
}
