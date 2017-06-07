package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertTrue;

public class ReturnCommandTest {

    ReturnCommand command;
    private Book[] books;
    User user;
    Session session;

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
        user = new User("Kat Hicks", "kathicks@london.com", "020 8123 9876","165-7864", "dogcatrabbit");
        session = new Session();
        session.setUser(user);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void testReturnValidBook() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        books[4].checkOut(user);
        command.run(books, session);
        assertTrue(!books[4].isOnLoan());
    }

    @Test
    public void testReturnConfirmationMessage() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Brave New World".getBytes());
        System.setIn(in);
        books[4].checkOut(user);
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the item."));
    }

    @Test
    public void testInvalidReturnMessage() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Alone in Berlin".getBytes());
        System.setIn(in);
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains("That is not a valid item to return."));
    }
}
