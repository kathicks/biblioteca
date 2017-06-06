package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca self = new Biblioteca();
        self.open();
        self.run();
    }

    private String welcomeMessage = "Welcome to Biblioteca!";
    private String[] validInputs = new String[] {"L", "C", "R", "Q"};
    private Command[] commands = new Command[] {
            new ListCommand("L",
                    "List available books"),
            new CheckOutCommand("C",
                    "Check out a book"),
            new ReturnCommand("R", "Return a book"),
            new Command("M", "List available movies"),
            new Command("Q", "Quit")
    };
    private Book[] books = new Book[] {
            new Book(
                    "Half of a Yellow Sun",
                    "Chimamanda Adiche",
                    2006,
                    false ),
            new Book(
                    "Things Fall Apart",
                    "Chinua Achebe",
                    1958,
                    false ),
            new Book(
                    "Norwegian Wood",
                    "Haruki Murakami",
                    1987,
                    false),
            new Book(
                    "The Buried Giant",
                    "Kazuo Ishiguro",
                    2015,
                    false),
            new Book(
                    "Brave New World",
                    "Aldous Huxley",
                    1932,
                    false)
    };

    private Movie[] movies = new Movie[] {
            new Movie("Clueless",
                    1995,
                    "Amy Heckerling",
                    8),
            new Movie("The Harder They Come",
                    1973,
                    "Perry Henzell",
                    7),
            new Movie("Happy Go Lucky",
                    2008,
                    "Mike Leigh",
                    6)
    };

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Book[] getBooks() {
        return books;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public Command[] getCommands() {
        return commands;
    }

    public String formatCommands() {
        String result = "";
        for (Command command : getCommands()) {
            result += command.toString() + "\n";
        }
        return result;
    }

    public void open() {
        System.out.println(getWelcomeMessage() + "\n\n" + formatCommands());
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        String command = scan.next().substring(0, 1);
        while (!Objects.equals(command, "Q")) {
            respondToInput(command);
            command = scan.next().substring(0, 1);
        }
    }

    private void respondToInput(String command) {
        if (isValidCommand(command)) {
            executeCommand(command);
        } else {
            System.out.println("Select a valid option!");
        }
    }

    private void executeCommand(String command) {
        for (Command element : getCommands()) {
            if (Objects.equals(command, element.getSymbol())) {
                element.run(getBooks());
            }
        }
    }

    private boolean isValidCommand(String command) {
        return Arrays.asList(validInputs).contains(command);
    }

}
