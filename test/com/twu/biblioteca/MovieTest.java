package com.twu.biblioteca;

import com.twu.biblioteca.Items.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;
    String sampleOutput;

    @Before
    public void setUp() {
        movie = new Movie("Clueless", 1995, "Amy Heckerling", 7, false);
        sampleOutput = "            Clueless | 1995 | Amy Heckerling | 7";
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

    @Test
    public void testToString() {
        assertEquals(movie.toString(), sampleOutput);
    }
}
