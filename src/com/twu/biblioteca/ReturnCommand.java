package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class ReturnCommand extends Command {

    public ReturnCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Book[] books) {
        System.out.println("Enter book title:");
        Scanner input = new Scanner(System.in);
        String bookTitle = input.nextLine();
        for (Book book : books) {
            if (Objects.equals(book.getTitle(), bookTitle)) {
                if (book.checkIn()){
                    System.out.println("Thank you for returning the book.");
                    return;
                }
            }
        }
        System.out.println("That is not a valid book to return.");
    }
}
