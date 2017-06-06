package com.twu.biblioteca;

import java.util.Objects;
import java.util.Scanner;

public class ReturnCommand extends Command {

    public ReturnCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items) {
        System.out.println("Enter item title:");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        for (Item item : items) {
            if (Objects.equals(item.getTitle(), title)) {
                if (item.checkIn()){
                    System.out.println("Thank you for returning the item.");
                    return;
                }
            }
        }
        System.out.println("That is not a valid item to return.");
    }
}
