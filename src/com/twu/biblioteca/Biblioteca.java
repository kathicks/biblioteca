package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca self = new Biblioteca();

        self.open();
        self.run();
    }

    private String welcomeMessage = "Welcome to Biblioteca!";
    private String menu = "L: List books";

    private Book[] books = new Book[] {
            new Book(
                    "Half of a Yellow Sun",
                    "Chimamanda Adiche",
                    2006),
            new Book(
                    "Things Fall Apart",
                    "Chinua Achebe",
                    1958),
            new Book(
                    "Norwegian Wood",
                    "Haruki Murakami",
                    1987),
            new Book(
                    "The Buried Giant",
                    "Kazuo Ishiguro",
                    2015),
            new Book(
                    "Brave New World",
                    "Aldous Huxley",
                    1932)
    };

    public Book[] getBooks() {
        return books;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getMenu() {
        return menu;
    }

    public String listBooks() {
        String result = "";
        for (Book book : books) {
            result += book.toString() + "\n";
        }
        return result;
    }

    public void open() {
        System.out.println(getWelcomeMessage() + "\n\n" + getMenu());
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        String command = scan.next().substring(0, 1);

        while (!Objects.equals(command, "Q")) {
            if (Objects.equals(command, "L")) {
                System.out.println(listBooks());
            } else {
                System.out.println("Select a valid option!");
            }
            command = scan.next().substring(0, 1);
        }
    }

}
