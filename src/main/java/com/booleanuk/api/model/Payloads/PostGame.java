package com.booleanuk.api.model.payloads;

public class PostGame {
    private String title;
    private String genre;
    private Boolean publisher;
    private int releaseYear;
    private Boolean isEarlyAccess;

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