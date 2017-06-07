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

    public void runCommand(String command, User[] users) {
        if (command.equals("S")) {
            signIn(users);
        } else {
            printDetails();
        }
    }

    private void printDetails() {
        try {
            System.out.println(getUser().toString());
        } catch (Exception e) {
            System.out.println("Error! You need to be signed in!");
        }
    }

    private void signIn(User[] users) {
        String libNumber = CommandInterface.takeLibNumber();
        User sessionUser = findUser(libNumber, users);
        if (sessionUser != null) {
            String password = CommandInterface.takePassword();
            if (isValidatedPassword(sessionUser, password)) {
                setUser(sessionUser);
            };
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

    private boolean isValidatedPassword(User sessionUser, String password) {
        if (Objects.equals(sessionUser.getPassword(), password)) {
            return CommandInterface.confirmPassword();
        } else {
            return CommandInterface.declinePassword();
        }
    }

}
