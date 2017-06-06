package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class CheckOutCommand extends Command {

    public CheckOutCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items) {
        System.out.println("Enter item title:");
        Scanner input = new Scanner(System.in);
        String bookTitle = input.nextLine();
        for (Item book : items) {
            if (Objects.equals(book.getTitle(), bookTitle)) {
                if (book.checkOut()){
                    System.out.println("Thank you! Enjoy.");
                    return;
                }
            }
        }
        System.out.println("That item is not available.");
    }
}
