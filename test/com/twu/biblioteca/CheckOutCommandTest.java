package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

public class CheckOutCommandTest {

    private CheckOutCommand command;
    private Book[] books;
    private Session session;

    @Before
    public void setUp() {
        command = new CheckOutCommand("C", "Check out a book");
        books = new Book[] {
                new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false),
                new Book("Things Fall Apart", "Chinua Achebe", 1958, false),
                new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
                new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
                new Book("Brave New World", "Aldous Huxley", 1932, false)
        };
        session = new Session();
        session.setUser(new User("165-7864", "dogcatrabbit"));
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testCheckOutValidBook() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        command.run(books, session);
        assertTrue(books[4].isOnLoan());
    }

    @Test
    public void testCheckOutConfirmationMessage() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy."));
    }

    @Test
    public void testInvalidCheckOutMessage() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Alone in Berlin".getBytes());
        System.setIn(in);
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains("That item is not available."));
    }
}
