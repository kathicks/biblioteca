package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private boolean isOnLoan;

    public Book(String title, String author, int yearPublished, boolean isOnLoan) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isOnLoan = isOnLoan;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public boolean checkOut() {
        if (!isOnLoan) {
            setOnLoan(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn() {
        if (isOnLoan) {
            setOnLoan(false);
            return true;
        } else {
            return false;
        }
    }

    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;
    }

    public String toString() {
        return String.format("%20s | %18s | %4d", getTitle(), getAuthor(), getYearPublished());
    }
}
