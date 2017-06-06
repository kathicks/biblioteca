package com.twu.biblioteca;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book[] books;
    private String sampleOutput;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        books = new Book[] {
                    new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006),
                    new Book("Things Fall Apart", "Chinua Achebe", 1958),
                    new Book("Norwegian Wood", "Haruki Murakami", 1987),
                    new Book("The Buried Giant", "Kazuo Ishiguro", 2015),
                    new Book("Brave New World", "Aldous Huxley", 1932)
                };
        sampleOutput = "Half of a Yellow Sun |  Chimamanda Adiche | 2006";
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals(biblioteca.welcomeMessage(), "Welcome to Biblioteca!");
    }

    @Test
    public void testGetBooks() {
        assertThat(biblioteca.getBooks(), new SamePropertyValuesAs(books));
    }

    @Test
    public void testListBooks()  {
        assertTrue(biblioteca.listBooks().contains(sampleOutput));
    }

    @Test
    public void testBookDetails() {
        assertEquals(biblioteca.getBooks()[0].getAuthor(), "Chimamanda Adiche");
    }
}
