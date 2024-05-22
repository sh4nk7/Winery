package test;

import javafx.beans.property.SimpleStringProperty;
import org.junit.Test;
import sample.Order;
import sample.Request;
import sample.User;
import sample.Wine;

import static org.junit.Assert.*;

public class OrderTest {

    private static User u1 = new User("giuseppe", "1234", 0);
    private static User u2 = new User("derby", "0000", 0);

    private static Wine w1 = new Wine("Sangue di Giuda", "Ottimo con la carne", "Testi", 3, 2003);
    private static Wine w2 = new Wine("Lambrusco", "Ottimo con i primi piatti", "Giusti", 12, 2007);

    private static int quantity1 = 1;
    private static int quantity2 = 2;

    private static boolean shipped1 = false;
    private static boolean shipped2 = true;

    @Test
    public void getOrderer() {
        Order o = new Order();

        assertEquals(new User(), o.getOrderer());

        o = new Order(u1, w1, quantity1, shipped1);
        assertEquals(u1, o.getOrderer());

        o = new Order(u2, w1, quantity1, shipped1);
        assertEquals(u2, o.getOrderer());
    }

    @Test
    public void setOrderer() {
        Order o = new Order();

        o.setOrderer(u1);
        assertEquals(u1, o.getOrderer());

        o.setOrderer(u2);
        assertEquals(u2, o.getOrderer());
    }

    @Test
    public void getOrderedWine() {
        Order o = new Order();

        assertEquals(new Wine(), o.getOrderedWine());

        o = new Order(u1, w1, quantity1, shipped1);
        assertEquals(w1, o.getOrderedWine());

        o = new Order(u1, w2, quantity1, shipped1);
        assertEquals(w2, o.getOrderedWine());
    }

    @Test
    public void setOrderedWine() {
        Order o = new Order();

        o.setOrderedWine(w1);
        assertEquals(w1, o.getOrderedWine());

        o.setOrderedWine(w2);
        assertEquals(w2, o.getOrderedWine());
    }

    @Test
    public void getQuantity() {
        Order o = new Order();

        assertEquals(0, o.getQuantity());

        o = new Order(u1, w1, quantity1, shipped1);
        assertEquals(quantity1, o.getQuantity());

        o = new Order(u1, w1, quantity2, shipped1);
        assertEquals(quantity2, o.getQuantity());
    }

    @Test
    public void setQuantity() {
        Order o = new Order();

        o.setQuantity(quantity1);
        assertEquals(quantity1, o.getQuantity());

        o.setQuantity(quantity2);
        assertEquals(quantity2, o.getQuantity());
    }

    @Test
    public void isShipped() {
        Order o = new Order();

        assertFalse(o.isShipped());

        o = new Order(u1, w1, quantity1, false);
        assertFalse(o.isShipped());

        o = new Order(u1, w1, quantity1, true);
        assertTrue(o.isShipped());
    }

    @Test
    public void setShipped() {
        Order o = new Order();

        o.setShipped(false);
        assertFalse(o.isShipped());

        o.setShipped(true);
        assertTrue(o.isShipped());
    }

    @Test
    public void getOrderStatus() {
        Order o = new Order();
        SimpleStringProperty confirmedProperty = new SimpleStringProperty("Confirmed");
        SimpleStringProperty shippedProperty = new SimpleStringProperty("Shipped");

        assertEquals(confirmedProperty.get(), o.getOrderStatus().get());

        o = new Order(u1, w1, quantity1, false);
        assertEquals(confirmedProperty.get(), o.getOrderStatus().get());

        o = new Order(u1, w1, quantity1, true);
        assertEquals(shippedProperty.get(), o.getOrderStatus().get());
    }

    @Test
    public void testToString() {
        Order o = new Order(u1, w1, quantity1, shipped1);
        String expected = "wine=[" + o.getOrderedWine() + "], " +
                "user=[" + o.getOrderer() + "], " +
                "quantity=" + o.getQuantity() + ", " +
                "shipped=" + o.isShipped();

        assertEquals(expected, o.toString());
    }

    @Test
    public void testEquals() {
        Order o1 = new Order(u1, w1, quantity1, shipped1);
        Order o2 = null;

        assertFalse(o1.equals(o2));
        o2 = new Order(u2, w2, quantity2, shipped2);
        assertFalse(o1.equals(o2));
        o2.setOrderer(u1);
        assertFalse(o1.equals(o2));
        o2.setOrderedWine(w1);
        assertFalse(o1.equals(o2));
        o2.setQuantity(quantity1);
        assertFalse(o1.equals(o2));
        o2.setShipped(shipped1);
        assertTrue(o1.equals(o2));
        assertTrue(o2.equals(o1));
    }
}