package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertTrue;

public class ListMovieCommandTest {

    ListMovieCommand command;
    private Movie[] movies;
    private String sampleOutput;

    @Before
    public void setUp() {
        command = new ListMovieCommand("M", "List available movies");
        movies = new Movie[]{
                new Movie("Clueless", 1995, "Amy Heckerling", 8),
                new Movie("The Harder They Come", 1973, "Perry Henzell", 7),
                new Movie("Happy Go Lucky", 2008, "Mike Leigh", 6)
        };
        sampleOutput = "The Harder They Come | 1973 |  Perry Henzell | 7";
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testListingMovies()  {
        command.run(movies);
        assertTrue(systemOutRule.getLog().contains(sampleOutput));
    }

}
