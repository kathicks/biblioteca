package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    Command command;
    String sampleOutput;

    @Before
    public void setUp() {
        command = new Command("L", "List available books");
        sampleOutput = "L: List available books";
    }

    @Test
    public void testToString()  {
        assertEquals(command.toString(), sampleOutput);
    }
}
