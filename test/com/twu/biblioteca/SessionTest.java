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
                new User("Kat Hicks", "kathicks@london.com", "020 8123 9876","165-7864", "dogcatrabbit"),
                new User("Alice Tidey", "atidey@dunelm.fr", "0207 565 5656", "753-4967", "sunmoonrain"),
                new User("Isa Cipirska", "isa@cipirska.com", "0208 8888 2222","075-2395", "grassbutterflytail"),
                new User("Harry Jenkins", "jenkinsh@charity.co.uk", "020 8123 0000","876-2058", "umbrellashirtscarf")
        };
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testUserSessionShouldStartAsNull() {
        assertTrue(session.getUser() == null);
    }

}
