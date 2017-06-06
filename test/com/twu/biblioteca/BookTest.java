package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    Book book;
    String sampleOutput;

    @Before
    public void setUp() {
        book = new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false);
        sampleOutput = "Half of a Yellow Sun |  Chimamanda Adiche | 2006";
    }

    @Test
    public void testGetTitle() {
        assertEquals(book.getTitle(), "Half of a Yellow Sun");
    }

    @Test
    public void testGetAuthor() {
        assertEquals(book.getAuthor(), "Chimamanda Adiche");
    }

    @Test
    public void testGetYearPublished() {
        assertEquals(book.getYearPublished(), 2006);
    }

    @Test
    public void testToString() {
        assertEquals(book.toString(), sampleOutput);
    }
}
