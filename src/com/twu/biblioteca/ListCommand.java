package com.twu.biblioteca;

public class ListCommand extends Command {

    public ListCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items, Session sessionUser) {
        String result = "";
        for (Item book : items) {
            if (!book.isOnLoan()) {
                result += book.toString() + "\n";
            }
        }
        System.out.println(result);
    }
}
