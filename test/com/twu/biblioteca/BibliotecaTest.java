package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.*;

public class BibliotecaTest {

    Biblioteca biblioteca;
    String[] books;
    String list;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        books = new String[] {
                    "Half of a Yellow Sun",
                    "Things Fall Apart",
                    "Norwegian Wood",
                    "The Buried Giant",
                    "Brave New World"
                };
        list = "Half of a Yellow Sun\n" +
                "Things Fall Apart\n" +
                "Norwegian Wood\n" +
                "The Buried Giant\n" +
                "Brave New World\n";
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals(biblioteca.welcomeMessage(), "Welcome to Biblioteca!");
    }

    @Test
    public void testGetBooks() {
        assertArrayEquals(biblioteca.getBooks(), books);
    }

    @Test
    public void testListBooks()  {
        assertEquals(biblioteca.listBooks(), list);
    }
}
