package com.twu.biblioteca;

public class Movie extends Item {

    private int year;
    private String director;
    private int rating;

    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 10;

    public Movie(String title, int year, String director, int rating, boolean isOnLoan) {
        this.title = title;
        this.year = year;
        this.director = director;
        if (rating > MIN_RATING && rating <= MAX_RATING) {
            this.rating = rating;
        }
        this.isOnLoan = isOnLoan;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return String.format("%20s | %4d | %14s | %1d", getTitle(), getYear(), getDirector(), getRating());
    }
}
