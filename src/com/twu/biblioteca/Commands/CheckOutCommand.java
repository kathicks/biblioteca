package com.twu.biblioteca.Commands;

import com.twu.biblioteca.CommandInterface;
import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Session;

import java.util.Objects;

public class CheckOutCommand extends Command {

    public CheckOutCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items, Session session) throws Exception {
        String title = CommandInterface.takeItem();
        for (Item book : items) {
            if (Objects.equals(book.getTitle(), title)) {
                if (book.checkOut(session.getUser())){
                    System.out.println("Thank you! Enjoy.");
                    return;
                }
            }
        }
        System.out.println("That item is not available.");
    }
}
