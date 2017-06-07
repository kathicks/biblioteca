package com.twu.biblioteca;

public class Book extends Item {

    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished, boolean isOnLoan) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isOnLoan = isOnLoan;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String toString() {
        return String.format(
                "%20s | %18s | %4d",
                getTitle(),
                getAuthor(),
                getYearPublished()
        );
    }
}
