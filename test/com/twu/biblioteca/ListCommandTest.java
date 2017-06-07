package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertTrue;

public class ListCommandTest {

    ListCommand command;
    private Book[] books;
    private String sampleOutput;
    User user;
    Session session;

    @Before
    public void setUp() {
        command = new ListCommand("L", "List available books");
        books = new Book[] {
                new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false),
                new Book("Things Fall Apart", "Chinua Achebe", 1958, false),
                new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
                new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
                new Book("Brave New World", "Aldous Huxley", 1932, false)
        };
        sampleOutput = "Half of a Yellow Sun |  Chimamanda Adiche | 2006";
        user = new User("Kat Hicks", "kathicks@london.com", "020 8123 9876","165-7864", "dogcatrabbit");
        session = new Session();
        session.setUser(user);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testListingBooks()  {
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains(sampleOutput));
    }

    @Test
    public void testNotListingBooksOnLoan() throws Exception {
        books[0].checkOut(user);
        command.run(books, session);
        assertTrue(!systemOutRule.getLog().contains(sampleOutput));
    }

    @Test
    public void testListingBooksThatHaveBeenReturned() throws Exception {
        books[0].checkOut(user);
        books[0].checkIn(session);
        command.run(books, session);
        assertTrue(systemOutRule.getLog().contains(sampleOutput));
    }
}
