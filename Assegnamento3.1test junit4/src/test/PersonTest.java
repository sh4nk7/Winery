package test;

import org.junit.Test;
import sample.Person;
import sample.Request;
import sample.User;

import static org.junit.Assert.*;

public class PersonTest {

    private static String username1 = "giuseppe";
    private static String username2 = "derby";

    private static String password1 = "1234";
    private static String password2 = "0000";

    @Test
    public void getUsername() {
        Person p = new Person();

        assertEquals("", p.getUsername());

        p = new Person(username1, password1);
        assertEquals(username1, p.getUsername());

        p = new Person(username2, password1);
        assertEquals(username2, p.getUsername());
    }

    @Test
    public void setUsername() {
        Person p = new Person();

        p.setUsername(username1);
        assertEquals(username1, p.getUsername());

        p.setUsername(username2);
        assertEquals(username2, p.getUsername());
    }

    @Test
    public void getPassword() {
        Person p = new Person();

        assertEquals("", p.getPassword());

        p = new Person(username1, password1);
        assertEquals(username1, p.getUsername());

        p = new Person(username2, password1);
        assertEquals(username2, p.getUsername());
    }

    @Test
    public void setPassword() {
        Person p = new Person();

        p.setPassword(password1);
        assertEquals(password1, p.getPassword());

        p.setPassword(password2);
        assertEquals(password2, p.getPassword());
    }

    @Test
    public void testEquals() {
        Person p1 = new Person(username1, password1);
        Person p2 = null;

        assertFalse(p1.equals(p2));
        p2 = new Person(username2, password2);
        assertFalse(p1.equals(p2));
        p2.setUsername(username1);
        assertFalse(p1.equals(p2));
        p2.setPassword(password1);
        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
    }

    @Test
    public void testToString() {
        Person p = new Person(username1, password1);
        String expected = "username=\"" + p.getUsername() + "\", " +
                "password=\"" + p.getPassword() + "\"";
        assertEquals(expected, p.toString());
    }
}