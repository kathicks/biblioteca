package com.twu.biblioteca;

import java.util.Objects;

public class Session implements CommandInterface {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void signIn(User[] users) {
        String libNumber = CommandInterface.takeLibNumber();
        User sessionUser = findUser(libNumber, users);
        if (sessionUser != null) {
            String password = CommandInterface.takePassword();
            if (isValidatedPassword(sessionUser, password)) {
                setUser(sessionUser);
            };
        }
    }

    private boolean isValidatedPassword(User sessionUser, String password) {
        if (Objects.equals(sessionUser.getPassword(), password)) {
            return CommandInterface.confirmPassword();
        } else {
            return CommandInterface.declinePassword();
        }
    }

    private User findUser(String libNum, User[] users) {
        for (User user : users) {
            if (Objects.equals(user.getLibraryNumber(), libNum)) {
                return user;
            }
        }
        return null;
    }

}
