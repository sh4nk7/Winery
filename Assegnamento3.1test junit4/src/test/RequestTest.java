package test;

import javafx.beans.property.SimpleStringProperty;
import org.junit.Test;
import sample.Order;
import sample.Request;
import sample.User;
import sample.Wine;

import static org.junit.Assert.*;

public class RequestTest {

    private static User u1 = new User("giuseppe", "1234", 0);
    private static User u2 = new User("derby", "0000", 0);

    private static String wineName1 = "Sangue di Giuda";
    private static String wineName2 = "Lambrusco";

    @Test
    public void getRequester() {
        Request r = new Request();

        assertEquals(new User(), r.getRequester());

        r = new Request(u1, wineName1);
        assertEquals(u1, r.getRequester());

        r = new Request(u2, wineName1);
        assertEquals(u2, r.getRequester());
    }

    @Test
    public void setRequester() {
        Request r = new Request();

        r.setRequester(u1);
        assertEquals(u1, r.getRequester());

        r.setRequester(u2);
        assertEquals(u2, r.getRequester());
    }

    @Test
    public void getWineName() {
        Request r = new Request();

        assertEquals(null, r.getWineName());

        r = new Request(u1, wineName1);
        assertEquals(wineName1, r.getWineName());

        r = new Request(u1, wineName2);
        assertEquals(wineName2, r.getWineName());
    }

    @Test
    public void setWineName() {
        Request r = new Request();

        r.setWineName(wineName1);
        assertEquals(wineName1, r.getWineName());

        r.setWineName(wineName2);
        assertEquals(wineName2, r.getWineName());
    }

    @Test
    public void testEquals() {
        Request r1 = new Request(u1, wineName1);
        Request r2 = null;

        assertFalse(r1.equals(r2));
        r2 = new Request(u2, wineName2);
        assertFalse(r1.equals(r2));
        r2.setRequester(u1);
        assertFalse(r1.equals(r2));
        r2.setWineName(wineName1);
        assertTrue(r1.equals(r2));
        assertTrue(r2.equals(r1));
    }

    @Test
    public void testToString() {
        Request r = new Request(u1, wineName1);

        String expected = "requester=[" + r.getRequester() + "], " +
                "wineName=\"" + r.getWineName() + "\"";
        assertEquals(expected, r.toString());
    }
}