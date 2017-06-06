package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ReturnCommandTest {

    ReturnCommand command;
    private Book[] books;

    @Before
    public void setUp() {
        command = new ReturnCommand("R", "Return a book");
        books = new Book[] {
                new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false),
                new Book("Things Fall Apart", "Chinua Achebe", 1958, false),
                new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
                new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
                new Book("Brave New World", "Aldous Huxley", 1932, false)
        };
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testReturnValidBook() {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        books[4].checkOut();
        command.run(books);
        assertTrue(!books[4].isOnLoan());
    }

    @Test
    public void testReturnConfirmationMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        books[4].checkOut();
        command.run(books);
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the book."));
    }

    @Test
    public void testInvalidReturnMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("Alone in Berlin".getBytes());
        System.setIn(in);
        command.run(books);
        assertTrue(systemOutRule.getLog().contains("That is not a valid book to return."));
    }
}
