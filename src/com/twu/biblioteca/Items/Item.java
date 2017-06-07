package com.twu.biblioteca.Items;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.User;

public abstract class Item {

    public String title;
    public boolean isOnLoan;
    public User currentUser;

    public String getTitle() {
        return title;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public boolean checkOut(User user) throws Exception {
        validateUser(user);
        if (!isOnLoan) {
            setOnLoan(true);
            setCurrentUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn(Session session) throws Exception {
        validateUser(session.getUser());
        if (isOnLoan && currentUser.equals(session.getUser())) {
            setOnLoan(false);
            setCurrentUser(null);
            return true;
        } else {
            return false;
        }
    }

    private void validateUser(User user) throws Exception {
        if (user == null) {
            throw new Exception();
        }
    }

    private void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;
    }

    private void setCurrentUser(User user) {
        currentUser = user;
    }
}
