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
    private String[][] validInputs = new String[][] {
            {"L", "C", "R"},
            {"M", "B", "G"},
            {"Q"}};
    private Command[] commands = new Command[] {
        new ListCommand("L",
                "List available books"),
                new CheckOutCommand("C",
                        "Check out a book"),
                new ReturnCommand("R", "Return a book"),
                new ListCommand("M", "List available movies"),
                new CheckOutCommand("B", "Check out a movie" ),
                new ReturnCommand("G", "Return a movie"),
                new Command("Q", "Quit")
    };
    private Item[] books = new Item[] {
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

    private Item[] movies = new Item[] {
            new Movie("Clueless",
                    1995,
                    "Amy Heckerling",
                    8,
                    false),
            new Movie("The Harder They Come",
                    1973,
                    "Perry Henzell",
                    7,
                    false),
            new Movie("Happy Go Lucky",
                    2008,
                    "Mike Leigh",
                    6,
                    false)
    };

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Item[] getBooks() {
        return books;
    }

    public Item[] getMovies() {
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
        if (isABookCommand(command)) {
            findMatchingCommand(command, getBooks());
        } else {
            findMatchingCommand(command, getMovies());
        }
    }

    private void findMatchingCommand(String command, Item[] item) {
        for (Command element : getCommands()) {
            if (Objects.equals(command, element.getSymbol())) {
                element.run(item);
            }
        }
    }

    private boolean isValidCommand(String command) {
        for (String[] set : validInputs) {
            if (Arrays.asList(set).contains(command)) {
                return true;
            }
        }
        return false;
    }

    private boolean isABookCommand(String command) {
        return Arrays.asList(validInputs[0]).contains(command);
    }

}
