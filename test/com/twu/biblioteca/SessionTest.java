package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session;
    private User[] users;

    @Before
    public void setUp() {
        session = new Session();
        users   = new User[] {
                    new User("165-7864", "dogcatrabbit"),
                    new User("753-4967", "sunmoonrain"),
                    new User("075-2395", "grassbutterflytail"),
                    new User("876-2058", "umbrellashirtscarf")
        };
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testUserSessionShouldStartAsNull() {
        assertTrue(session.getUser() == null);
    }

}
