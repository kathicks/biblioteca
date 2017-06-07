package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Session;

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
