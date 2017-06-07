package com.twu.biblioteca;

public class User {

    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;

    public User(String name, String email, String phone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

}
