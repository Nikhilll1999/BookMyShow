package com.nctech.bookmyshow.dto;

public class ShowDTO {
    private Integer id;
    private String name;
    private String genre;
    private String rating;
    private String description;

    public ShowDTO() {

    }

    public ShowDTO(Integer id, String name, String genre, String rating, String description) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShowDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}