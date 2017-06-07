package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Items.Item;
import com.twu.biblioteca.Session;

public class Command {

    private String symbol;
    private String description;

    public Command(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return getSymbol() + ": " + getDescription();
    }

    public void run(Item[] items, Session sessionUser) throws Exception { }

}
