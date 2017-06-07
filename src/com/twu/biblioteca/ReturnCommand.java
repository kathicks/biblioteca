package com.twu.biblioteca;

import java.util.Objects;

public class ReturnCommand extends Command implements CommandInterface {

    public ReturnCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items, Session session) throws Exception {
        String title = CommandInterface.takeItem();
        for (Item item : items) {
            if (Objects.equals(item.getTitle(), title)) {
                if (item.checkIn(session)){
                    System.out.println("Thank you for returning the item.");
                    return;
                }
            }
        }
        System.out.println("That is not a valid item to return.");
    }
}
