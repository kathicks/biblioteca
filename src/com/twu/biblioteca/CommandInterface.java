package com.twu.biblioteca;

import com.twu.biblioteca.Commands.CheckOutCommand;
import com.twu.biblioteca.Commands.Command;
import com.twu.biblioteca.Commands.ListCommand;
import com.twu.biblioteca.Commands.ReturnCommand;

import java.util.Arrays;
import java.util.Scanner;

public interface CommandInterface {

    public static final Scanner commandInput   = new Scanner(System.in);
    public static final Scanner userInput      = new Scanner(System.in);

    public static final String welcomeMessage  = "Welcome to Biblioteca!";
    public static final String libNumberPrompt = "Enter your library number:";
    public static final String passwordPrompt  = "Enter your password:";
    public static final String itemPrompt      = "Enter item title:";
    public static final String[][] validInputs = new String[][] {
            {"L", "C", "R"},
            {"M", "B", "G"},
            {"S", "D", "Q"}};
    public static final Command[] commands     = new Command[] {
            new ListCommand("L",
                    "List available books"),
            new CheckOutCommand("C",
                    "Check out a book"),
            new ReturnCommand("R", "Return a book"),
            new ListCommand("M", "List available movies"),
            new CheckOutCommand("B", "Check out a movie" ),
            new ReturnCommand("G", "Return a movie"),
            new Command("S", "Sign in"),
            new Command("D", "See your personal details"),
            new Command("Q", "Quit")
    };

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static Command[] getCommands() {
        return commands;
    }

    public static String formatCommands() {
        StringBuilder result = new StringBuilder();
        for (Command command : commands) {
            result.append(command.toString()).append("\n");
        }
        return result.toString();
    }

    public static void open() {
        System.out.println(
                getWelcomeMessage() + "\n\n" +
                formatCommands()
        );
    }

    public static void promptValidCommand() {
        System.out.println("Select a valid option!");
    }

    public static String takeCommand() {
        return commandInput.next().substring(0, 1);
    }

    public static String takeItem() {
        System.out.println(itemPrompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String takeLibNumber() {
        System.out.println(libNumberPrompt);
        String result = userInput.nextLine();
        return result;
    }

    public static String takePassword() {
        System.out.println(passwordPrompt);
        return userInput.nextLine();
    }

    public static boolean isValidCommand(String command) {
        for (String[] set : validInputs) {
            if (Arrays.asList(set).contains(command)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isABookCommand(String command) {
        return Arrays.asList(validInputs[0]).contains(command);
    }

    public static boolean isASessionCommand(String command) {
        return Arrays.asList(validInputs[2]).contains(command);
    }

    public static boolean confirmPassword() {
        System.out.println("Sign in successful!");
        return true;
    }

    public static boolean declinePassword() {
        System.out.println("Please supply the correct password.");
        return false;
    }
}
