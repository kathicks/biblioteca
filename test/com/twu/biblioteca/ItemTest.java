package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemTest {

    Item book;

    @Before
    public void setUp() {
        book = new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false);
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
    public void testCheckOut() {
        book.checkOut();
        assertTrue(book.isOnLoan());
    }

    @Test
    public void testCheckIn() {
        book.checkOut();
        book.checkIn();
        assertTrue(!book.isOnLoan());
    }
}
