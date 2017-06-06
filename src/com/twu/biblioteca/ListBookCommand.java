package com.twu.biblioteca;

public class ListBookCommand extends Command {

    public ListBookCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items) {
        String result = "";
        for (Item book : items) {
            if (!book.isOnLoan()) {
                result += book.toString() + "\n";
            }
        }
        System.out.println(result);
    }
}
