package com.twu.biblioteca;

import java.util.Objects;

public class Biblioteca implements CommandInterface {

    public static void main(String[] args) {
        Biblioteca self = new Biblioteca();
        self.open();
        self.run();
    }

    private Session session = new Session();

    private Item[] books  = new Item[] {
            new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false ),
            new Book("Things Fall Apart", "Chinua Achebe", 1958, false ),
            new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
            new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
            new Book("Brave New World", "Aldous Huxley", 1932, false)
    };

    private Item[] movies = new Item[] {
            new Movie("Clueless", 1995, "Amy Heckerling", 8, false),
            new Movie("The Harder They Come", 1973, "Perry Henzell", 7, false),
            new Movie("Happy Go Lucky", 2008, "Mike Leigh", 6, false)
    };

    private User[] users  = new User[] {
            new User("Kat Hicks", "kathicks@london.com", "020 8123 9876","165-7864", "dogcatrabbit"),
            new User("Alice Tidey", "atidey@dunelm.fr", "0207 565 5656", "753-4967", "sunmoonrain"),
            new User("Isa Cipirska", "isa@cipirska.com", "0208 8888 2222","075-2395", "grassbutterflytail"),
            new User("Harry Jenkins", "jenkinsh@charity.co.uk", "020 8123 0000","876-2058", "umbrellashirtscarf")
    };

    public Item[] getBooks() {
        return books;
    }

    public Item[] getMovies() {
        return movies;
    }

    public User[] getUsers() {
        return users;
    }

    public void open() {
        System.out.println(
            CommandInterface.getWelcomeMessage() + "\n\n" +
            CommandInterface.formatCommands()
        );
    }

    public void run() {
        String command = CommandInterface.takeCommand();
        while (!Objects.equals(command, "Q")) {
            dealWithUserInput(command);
            command = CommandInterface.takeCommand();
        }
    }

    private void dealWithUserInput(String command) {
        if (CommandInterface.isValidCommand(command)) {
            findMatchingCommandObject(command);
        } else {
            System.out.println("Select a valid option!");
        }
    }

    private void findMatchingCommandObject(String command) {
        if (command.equals("S")) {
            session.signIn(getUsers());
        } else if (CommandInterface.isABookCommand(command)) {
            runCommandObject(command, getBooks());
        } else {
            runCommandObject(command, getMovies());
        }
    }

    private void runCommandObject(String command, Item[] item) {
        for (Command element : CommandInterface.getCommands()) {
            if (Objects.equals(command, element.getSymbol())) {
                try {
                    element.run(item, session);
                } catch (Exception e){
                    System.out.println("Error! You need to be signed in!");
                }
            }
        }
    }

}
