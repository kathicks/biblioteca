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
                    new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false),
                    new Book("Things Fall Apart", "Chinua Achebe", 1958, false),
                    new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
                    new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
                    new Book("Brave New World", "Aldous Huxley", 1932, false)
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
    public void testGetBooks() {
        assertThat(biblioteca.getBooks(), new SamePropertyValuesAs(books));
    }

    @Test
    public void testFormatCommands() {
        assertEquals(biblioteca.formatCommands(), "L: List available books\nC: Check out a book\nR: Return a book\nM: List available movies\nQ: Quit\n");
    }

    @Test
    public void testOpenDisplaysWelcomeMessageAndMenu() {
        biblioteca.open();
        assertEquals("Welcome to Biblioteca!\n" + "\n" +
                "L: List available books\nC: Check out a book\nR: Return a book\nM: List available movies\nQ: Quit\n\n", systemOutRule.getLog());
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
