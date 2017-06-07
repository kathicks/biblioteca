package com.twu.biblioteca;

import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemTest {

    Item book;
    User user;
    Session session;

    @Before
    public void setUp() {
        book = new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false);
        user = new User("Kat Hicks", "kathicks@london.com", "020 8123 9876","165-7864", "dogcatrabbit");
        session = new Session();
        session.setUser(user);
    }

    @Test
    public void testGetTitle() {
        assertEquals(book.getTitle(), "Half of a Yellow Sun");
    }

    @Test
    public void testIsOnLoan() {
        assertTrue(!book.isOnLoan());
    }

    @Test
    public void testCheckOutChangesOnLoanField() throws Exception {
        book.checkOut(user);
        assertTrue(book.isOnLoan());
    }

    @Test
    public void testCheckInChangesOnLoanField() throws Exception {
        book.checkOut(user);
        book.checkIn(session);
        assertTrue(!book.isOnLoan());
    }

    @Test
    public void testCheckOutAssignsCurrentUser() throws Exception {
        book.checkOut(user);
        assertEquals(book.currentUser, user);
    }

    @Test
    public void testCheckInMakesCurrentUserNull() throws Exception {
        book.checkOut(user);
        book.checkIn(session);
        assertTrue(book.currentUser == null);
    }
}
