package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void testWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(biblioteca.welcomeMessage(), "Welcome to Biblioteca!");
    }

}
