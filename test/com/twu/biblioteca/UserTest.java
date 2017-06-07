package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(
                "Kat Hicks",
                "kathicks@london.com",
                "020 8123 9876",
                "123-4567",
                "libraryuser17"
                );
    }

    @Test
    public void testGetName() {
        assertEquals(user.getName(), "Kat Hicks");
    }

    @Test
    public void testGetEmail() {
        assertEquals(user.getEmail(), "kathicks@london.com");
    }

    @Test
    public void testGetPhone() {
        assertEquals(user.getPhone(), "020 8123 9876");
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
