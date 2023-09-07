package com.nctech.bookmyshow.dto;

public class TicketDTO {
    private Integer id;
    private String movie;
    private String time;
    private Float price;
    private String seatNumber;
    private Integer UserID;

    public TicketDTO() {

    }
    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        this.UserID = userID;
    }

    /**
     * Constructs a new {@link TicketDTO} object with the specified parameters.
     *
     * @param id         the ID of the ticket
     * @param movie      the movie name
     * @param time       the show time
     * @param price      the ticket price
     * @param seatNumber the seat number
     * @param userID     the ID of the user who booked the ticket
     */

    public TicketDTO(Integer id, String movie, String time, Float price, String seatNumber, Integer UserID) {
        this.id = id;
        this.movie = movie;
        this.time = time;
        this.price = price;
        this.seatNumber = seatNumber;
        this.UserID = UserID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", movie='" + movie + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", seatNumber='" + seatNumber + '\'' +
                ", createdBy='" + UserID + '\'' +
                '}';
    }
}
