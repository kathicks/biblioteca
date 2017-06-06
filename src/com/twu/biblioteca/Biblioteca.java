package com.twu.biblioteca;

public class Biblioteca {

    public static void main(String[] args) {
        Biblioteca self = new Biblioteca();

        System.out.println(self.welcomeMessage() + "\n");
        System.out.println(self.listBooks());
    }

    private Book[] books = new Book[] {
            new Book(
                    "Half of a Yellow Sun",
                    "Chimamanda Adiche",
                    2006),
            new Book(
                    "Things Fall Apart",
                    "Chinua Achebe",
                    1958),
            new Book(
                    "Norwegian Wood",
                    "Haruki Murakami",
                    1987),
            new Book(
                    "The Buried Giant",
                    "Kazuo Ishiguro",
                    2015),
            new Book(
                    "Brave New World",
                    "Aldous Huxley",
                    1932)
    };

    public Book[] getBooks() {
        return books;
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String listBooks() {
        String result = "";
        for (Book book : books) {
            result += String.format("%20s | %18s | %4d", book.getTitle(), book.getAuthor(), book.getYearPublished());
            result += "\n";
        }
        return result;
    }

}
