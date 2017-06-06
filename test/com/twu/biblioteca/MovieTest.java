package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Clueless", 1995, "Amy Heckerling", 7);
    }

    @Test
    public void testGetName() {
        assertEquals(movie.getTitle(), "Clueless");
    }

    @Test
    public void testGetYear() {
        assertEquals(movie.getYear(), 1995);
    }

    @Test
    public void testGetDirector() {
        assertEquals(movie.getDirector(), "Amy Heckerling");
    }

    @Test
    public void testGetRating() {
        assertEquals(movie.getRating(), 7);
    }
}
