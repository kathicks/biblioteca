package com.twu.biblioteca;

import com.twu.biblioteca.Commands.CheckOutCommand;
import com.twu.biblioteca.Commands.Command;
import com.twu.biblioteca.Commands.ListCommand;
import com.twu.biblioteca.Commands.ReturnCommand;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CommandInterfaceTest {

    private Command[] commands;
    private String commandList;

    @Before
    public void setUp() {
        commands = new Command[] {
                new ListCommand("L",
                "List available books"),
                new CheckOutCommand("C",
                        "Check out a book"),
                new ReturnCommand("R", "Return a book"),
                new ListCommand("M", "List available movies"),
                new CheckOutCommand("B", "Check out a movie" ),
                new ReturnCommand("G", "Return a movie"),
                new Command("S", "Sign in"),
                new Command("D", "See your personal details"),
                new Command("Q", "Quit")
        };
        commandList = "L: List available books\n" +
                "C: Check out a book\n" +
                "R: Return a book\n" +
                "M: List available movies\n" +
                "B: Check out a movie\n" +
                "G: Return a movie\n" +
                "S: Sign in\n" +
                "D: See your personal details\n" +
                "Q: Quit\n";
    }

    @Test
    public void testGetCommands() {
        assertThat(CommandInterface.getCommands(), new SamePropertyValuesAs(commands));
    }

    @Test
    public void testFormatCommands() {
        assertEquals(CommandInterface.formatCommands(), commandList);
    }
}
