package com.twu.biblioteca;

public class Item {

    public String title;
    public boolean isOnLoan;

    public String getTitle() {
        return title;
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
}
