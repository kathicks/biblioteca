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
    private User[] users;
    private String commandList;
    private String sampleOutput;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
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

        users = new User[] {
                new User("165-7864", "dogcatrabbit"),
                new User("753-4967", "sunmoonrain"),
                new User("075-2395", "grassbutterflytail"),
                new User("876-2058", "umbrellashirtscarf")
        };
        commandList = "L: List available books\n" +
                "C: Check out a book\n" +
                "R: Return a book\n" +
                "M: List available movies\n" +
                "B: Check out a movie\n" +
                "G: Return a movie\n" +
                "S: Sign in\n" +
                "Q: Quit\n";
        sampleOutput = "Half of a Yellow Sun |  Chimamanda Adiche | 2006";
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testGetBooks() {
        assertThat(biblioteca.getBooks(), new SamePropertyValuesAs(books));
    }

    @Test
    public void testGetMovies() {
        assertThat(biblioteca.getMovies(), new SamePropertyValuesAs(movies));
    }

    @Test
    public void testGetUsers() {
        assertThat(biblioteca.getUsers(), new SamePropertyValuesAs(users));
    }

    @Test
    public void testOpenDisplaysWelcomeMessageAndMenu() {
        biblioteca.open();
        assertEquals("Welcome to Biblioteca!\n" + "\n" + commandList + "\n", systemOutRule.getLog());
    }

    @Test
    public void testRunningWithQuitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
        System.setIn(in);
        biblioteca.run();
        assertEquals("", systemOutRule.getLog());
    }
}
