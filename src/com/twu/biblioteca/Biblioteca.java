package com.twu.biblioteca;

public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca self = new Biblioteca();

        System.out.println(self.welcomeMessage() + "\n");
        System.out.println(self.listBooks());
    }

    private String[] books = new String[] {
            "Half of a Yellow Sun",
            "Things Fall Apart",
            "Norwegian Wood",
            "The Buried Giant",
            "Brave New World"
    };

    public String[] getBooks() {
        return books;
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String listBooks() {
        String result = "";
        for (String book : books) {
            result += book;
            result += '\n';
        }
        return result;
    }

}
