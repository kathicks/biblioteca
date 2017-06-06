package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(
                "123-4567",
                "libraryuser17");
    }

    @Test
    public void testGetLibraryNumber() {
        assertEquals(user.getLibraryNumber(), "123-4567");
    }

    @Test
    public void testGetPassword() {
        assertEquals(user.getPassword(), "libraryuser17");
    }
}
