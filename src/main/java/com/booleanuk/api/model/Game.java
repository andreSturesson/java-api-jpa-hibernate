package com.booleanuk.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String genre;
    private Boolean publisher;
    private int releaseYear;
    private Boolean isEarlyAccess;

    public Game(String title, String genre, Boolean publisher, int releaseYear, Boolean isEarlyAccess) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.isEarlyAccess = isEarlyAccess;
    }
    public Game() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getPublisher() {
        return publisher;
    }

    public void setPublisher(Boolean publisher) {
        this.publisher = publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Boolean getIsEarlyAccess() {
        return isEarlyAccess;
    }

    public void setIsEarlyAccess(Boolean isEarlyAccess) {
        this.isEarlyAccess = isEarlyAccess;
    }
}