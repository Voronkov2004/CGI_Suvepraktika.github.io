package com.example.CGI.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, rating, full_text, picture_link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Films(String title, String rating, String full_text, String picture_link) {
        this.title = title;
        this.rating = rating;
        this.full_text = full_text;
        this.picture_link = picture_link;
    }

    public String getPicture_link() {
        return picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    public Films() {
    }
}
