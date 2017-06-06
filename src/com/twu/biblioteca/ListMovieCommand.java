package com.twu.biblioteca;

public class ListMovieCommand extends Command {

    public ListMovieCommand(String symbol, String description) {
        super(symbol, description);
    }

    public void run(Item[] items) {
        String result = "";
        for (Item movie : items) {
            result += movie.toString() + "\n";
        }
        System.out.println(result);
    }
}

