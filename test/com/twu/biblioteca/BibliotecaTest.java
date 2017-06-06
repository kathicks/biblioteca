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
    private Item[] books;
    private Item[] movies;
    private Command[] commands;
    private String sampleOutput;
    private String commandList;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        commandList = "L: List available books\n" +
                "C: Check out a book\n" +
                "R: Return a book\n" +
                "M: List available movies\n" +
                "B: Check out a movie\n" +
                "G: Return a movie\n" +
                "Q: Quit\n";
        books = new Item[] {
                    new Book("Half of a Yellow Sun", "Chimamanda Adiche", 2006, false),
                    new Book("Things Fall Apart", "Chinua Achebe", 1958, false),
                    new Book("Norwegian Wood", "Haruki Murakami", 1987, false),
                    new Book("The Buried Giant", "Kazuo Ishiguro", 2015, false),
                    new Book("Brave New World", "Aldous Huxley", 1932, false)
                };
        movies = new Item[] {
                    new Movie("Clueless", 1995, "Amy Heckerling", 8, false),
                    new Movie("The Harder They Come", 1973, "Perry Henzell", 7, false),
                    new Movie("Happy Go Lucky", 2008, "Mike Leigh", 6, false)
                };
        commands = new Command[] {
                new ListCommand("L",
                        "List available books"),
                new CheckOutCommand("C",
                        "Check out a book"),
                new ReturnCommand("R", "Return a book"),
                new ListCommand("M", "List available movies"),
                new CheckOutCommand("B", "Check out a movie" ),
                new ReturnCommand("G", "Return a movie"),
                new Command("Q", "Quit")
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
    public void testGetMovies() {
        assertThat(biblioteca.getMovies(), new SamePropertyValuesAs(movies));
    }

    @Test
    public void testGetCommands() {
        assertThat(biblioteca.getCommands(), new SamePropertyValuesAs(commands));
    }

    @Test
    public void testFormatCommands() {
        assertEquals(biblioteca.formatCommands(), commandList);
    }

    @Test
    public void testOpenDisplaysWelcomeMessageAndMenu() {
        biblioteca.open();
        assertEquals("Welcome to Biblioteca!\n" + "\n" + commandList + "\n", systemOutRule.getLog());
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
