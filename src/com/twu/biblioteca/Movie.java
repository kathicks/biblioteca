package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int rating;

    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 10;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        if (rating > MIN_RATING && rating <= MAX_RATING) {
            this.rating = rating;
        }
    }

    public String getName() {
        return name;
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
}
