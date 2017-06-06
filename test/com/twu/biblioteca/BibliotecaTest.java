package com.twu.biblioteca;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

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

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testGetWelcomeMessage() {
        assertEquals(biblioteca.getWelcomeMessage(), "Welcome to Biblioteca!");
    }

    @Test
    public void testGetMenu() {
        assertEquals(biblioteca.getMenu(), "L: List books");
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
    public void testOpenDisplaysMenu() {
        biblioteca.open();
        assertEquals("Welcome to Biblioteca!\n" + "\n" +
                "L: List books\n", systemOutRule.getLog());
    }

    @Test
    public void testRunningWithInvalidCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("H\nQ".getBytes());
        System.setIn(in);
        biblioteca.run();
        assertEquals("Select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void testRunningWithQuitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
        System.setIn(in);
        biblioteca.run();
        assertEquals("", systemOutRule.getLog());
    }
}
