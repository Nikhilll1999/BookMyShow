package com.nctech.bookmyshow.dto;

public class BookingDTO {
    private Integer id;
    private String chosenMovie;
    private String chooseBy;
    private String time;
    private Integer userID;
    private Integer theaterID;

    public BookingDTO() {

    }
    public BookingDTO(Integer id, String chosenMovie, String chooseBy, String time, Integer userID, Integer theaterID) {
        this.id = id;
        this.chosenMovie = chosenMovie;
        this.chooseBy = chooseBy;
        this.time = time;
        this.theaterID = theaterID;
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChosenMovie() {
        return chosenMovie;
    }

    public void setChosenMovie(String chosenMovie) {
        this.chosenMovie = chosenMovie;
    }

    public String getChooseBy() {
        return chooseBy;
    }

    public void setChooseBy(String chooseBy) {
        this.chooseBy = chooseBy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", chosenMovie='" + chosenMovie + '\'' +
                ", chooseBy='" + chooseBy + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
