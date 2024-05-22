package test;

import javafx.collections.ObservableList;
import javafx.util.Pair;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sample.*;

import java.util.HashMap;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WinehouseTest {

    private static Wine w1 = new Wine("Sangue di Giuda", "Ottimo con la carne", "Testi", 3, 2003);
    private static Wine w2 = new Wine("Lambrusco", "Ottimo con i primi piatti", "Giusti", 12, 2007);
    private static Wine w3 = new Wine("Prosecco","Perfetto per accompagnare i dolci","Verdi",8,2012);
    private static Wine w4 = new Wine("Malvasia","Il vino dolce perfetto","Bottioni",15,2005);
    private static Wine w5 = new Wine("Spumante","Perfetto per i brindisi","Bianchi",9,1999);
    private static Wine w6 = new Wine("Bonarda","Perfetto per le grigliate in compagnia","Branchi",10,2013);
    private static Wine w7 = new Wine("Brunello di Montalcino","Perfetto da degustare con i formaggi o da accompagnare alla carne","Raffini",19,1997);
    private static Wine w8 = new Wine("Moscato bianco","Perfetto per accompagnare un dolce momento","Frati",8,2002);
    private static Wine w9 = new Wine("Sauvignon","Abbinamento perfetto con spezie ed erbe aromatiche","Colli",15,2013);
    private static Wine w10 = new Wine("Franciacorta","Si sposa perfettamente con crostacei e primi ai frutti di mare","Trenti",12,2006);
    private static Wine w11 = new Wine("Merlot","Perfetto da accompagnare ad un piatto di carne","Fraschi",18,2007);
    private static Wine w12 = new Wine("Cabernet","Ottimo accompagnamento per una degustazione di formaggi morbidi","Fiaschi",12,2005);
    private static Wine w13 = new Wine("Montepulciano","Perfetto come accompagnamento per una carne rossa","Galassi",9,2017);
    private static Wine w14 = new Wine("Chardonnay","Da accompagnare con una pasta fatta in casa col tartufo","Sacchi",14,2008);
    private static Wine w15 = new Wine("Pinot Nero","Connubio perfetto con un filetto di carne insaporito al tartufo","Branchini",16,2012);

    private static User u1 = new User("giuseppe", "1234", 0);
    private static User u2 = new User("derby", "0000", 0);
    private static User u3 = new User("thomas", "18363", 0);
    private static User u4 = new User("katia", "84858", 0);
    private static User u5 = new User("francesca", "2222", 0);
    private static User u6 = new User("letizia", "1566", 1);

    private static Seller s1 = new Seller("martina", "5678");
    private static Seller s2 = new Seller("samuele", "abcd");

    private static Order o1 = new Order(u1, w2, 5, true);
    private static Order o2 = new Order(u3, w5, 2, false);
    private static Order o3 = new Order(u2, w4, 6, false);
    private static Order o4 = new Order(u1, w6, 4, true);
    private static Order o5 = new Order(u6, w2, 2, true);
    private static Order o6 = new Order(u3, w12, 4, true);
    private static Order o7 = new Order(u4, w1, 1, false);
    private static Order o8 = new Order(u5, w11, 2, false);

    private static Request r1 = new Request(u2, "Roero");
    private static Request r2 = new Request(u1, "Canavese");
    private static Request r3 = new Request(u5, "Monferrato");
    private static Request r4 = new Request(u3, "Moscato Giallo");

    @Test
    public void order01_getWines() {
        Winehouse whouse = new Winehouse();
        ObservableList<Wine> fetched = whouse.getWines();

        assertEquals(15, fetched.size());
        assertTrue(fetched.contains(w1));
        assertTrue(fetched.contains(w2));
        assertTrue(fetched.contains(w3));
        assertTrue(fetched.contains(w4));
        assertTrue(fetched.contains(w5));
        assertTrue(fetched.contains(w6));
        assertTrue(fetched.contains(w7));
        assertTrue(fetched.contains(w8));
        assertTrue(fetched.contains(w9));
        assertTrue(fetched.contains(w10));
        assertTrue(fetched.contains(w11));
        assertTrue(fetched.contains(w12));
        assertTrue(fetched.contains(w13));
        assertTrue(fetched.contains(w14));
        assertTrue(fetched.contains(w15));
    }

    @Test
    public void order02_getOrders() {
        Winehouse whouse = new Winehouse();
        ObservableList<Order> fetchedOrders = whouse.getOrders();

        assertEquals(8, fetchedOrders.size());
        assertTrue(fetchedOrders.contains(o1));
        assertTrue(fetchedOrders.contains(o2));
        assertTrue(fetchedOrders.contains(o3));
        assertTrue(fetchedOrders.contains(o4));
        assertTrue(fetchedOrders.contains(o5));
        assertTrue(fetchedOrders.contains(o6));
        assertTrue(fetchedOrders.contains(o7));
        assertTrue(fetchedOrders.contains(o8));
    }

    @Test
    public void order03_getSellers() {
        Winehouse whouse = new Winehouse();
        ObservableList<Seller> fetchedSellers = whouse.getSellers();

        assertEquals(2, fetchedSellers.size());
        assertTrue(fetchedSellers.contains(s1));
        assertTrue(fetchedSellers.contains(s2));
    }

    @Test
    public void order04_getMembers() {
        Winehouse whouse = new Winehouse();
        ObservableList<User> fetchedMembers = whouse.getMembers();

        assertEquals(6, fetchedMembers.size());
        assertTrue(fetchedMembers.contains(u1));
        assertTrue(fetchedMembers.contains(u2));
        assertTrue(fetchedMembers.contains(u3));
        assertTrue(fetchedMembers.contains(u4));
        assertTrue(fetchedMembers.contains(u5));
        assertTrue(fetchedMembers.contains(u6));
    }

    @Test
    public void order05_getRequestedWines() {
        Winehouse whouse = new Winehouse();
        ObservableList<Request> fetchedRequests = whouse.getRequestedWines();

        assertEquals(4, fetchedRequests.size());
        assertTrue(fetchedRequests.contains(r1));
        assertTrue(fetchedRequests.contains(r2));
        assertTrue(fetchedRequests.contains(r3));
        assertTrue(fetchedRequests.contains(r4));
    }

    @Test
    public void order06_login() {
        Winehouse whouse = new Winehouse();

        assertEquals(u1, whouse.login("giuseppe", "1234"));
        assertEquals(s2, whouse.login("samuele", "abcd"));
        assertNotEquals(u1, whouse.login("derby", "0000"));
        assertNull(whouse.login("giuseppe", "1233"));
    }

    @Test
    public void order07_signUp() {
        Winehouse whouse = new Winehouse();

        assertFalse(whouse.signUp("giuseppe", "aaaa"));
        int initialNumMembers = whouse.getMembers().size();
        assertTrue(whouse.signUp("chris", "tretre"));
        assertEquals(initialNumMembers + 1, whouse.getMembers().size());
    }

    @Test
    public void order08_findWinesName() {
        Winehouse whouse = new Winehouse();
        ObservableList<Wine> fetchedWinesForBonarda = whouse.findWinesName("Bonarda");
        ObservableList<Wine> fetchedWinesForArgiolas = whouse.findWinesName("Argiolas");

        assertEquals(1, fetchedWinesForBonarda.size());
        assertTrue((fetchedWinesForBonarda.contains(w6)));

        assertEquals(0, fetchedWinesForArgiolas.size());
    }

    @Test
    public void order09_getPendingOrders() {
        Winehouse whouse = new Winehouse();
        ObservableList<Order> fetchedOrders = whouse.getPendingOrders();

        assertEquals(4, fetchedOrders.size());
        assertTrue(fetchedOrders.contains(o2));
        assertTrue(fetchedOrders.contains(o3));
        assertTrue(fetchedOrders.contains(o7));
        assertTrue(fetchedOrders.contains(o8));
    }

    @Test
    public void order10_getPendingOrdersNo() {
        Winehouse whouse = new Winehouse();
        ObservableList<Order> fetchedOrders = whouse.getPendingOrders();

        assertEquals(4, fetchedOrders.size());
    }

    @Test
    public void order11_getWineByNameAndYear() {
        Winehouse whouse = new Winehouse();
        ObservableList<Wine> fetchedWinesForMontepulciano2017 = whouse.getWineByNameAndYear("Montepulciano", 2017);
        ObservableList<Wine> fetchedWinesForMontepulciano2016 = whouse.getWineByNameAndYear("Argiolas", 2016);

        assertEquals(1, fetchedWinesForMontepulciano2017.size());
        assertTrue((fetchedWinesForMontepulciano2017.contains(w13)));

        assertEquals(0, fetchedWinesForMontepulciano2016.size());
    }

    @Test
    public void order12_findWinesYear() {
        Winehouse whouse = new Winehouse();
        ObservableList<Wine> fetchedWinesFor2013 = whouse.findWinesYear(2013);
        ObservableList<Wine> fetchedWinesFor2002 = whouse.findWinesYear(2002);
        ObservableList<Wine> fetchedWinesFor2014 = whouse.findWinesYear(2014);

        assertEquals(2, fetchedWinesFor2013.size());
        assertTrue(fetchedWinesFor2013.contains(w6));
        assertTrue(fetchedWinesFor2013.contains(w9));

        assertEquals(1, fetchedWinesFor2002.size());
        assertTrue(fetchedWinesFor2002.contains(w8));

        assertEquals(0, fetchedWinesFor2014.size());
    }

    @Test
    public void order13_editWineQty() {
        Winehouse whouse = new Winehouse();

        int originalQty = whouse.findWinesName(w4.getName()).get(0).getQty();
        int newQty = originalQty + 10;
        whouse.editWineQty(w4, newQty);
        assertEquals(newQty, whouse.findWinesName(w4.getName()).get(0).getQty());
        whouse.editWineQty(w4, originalQty);
    }

    @Test
    public void order14_addWine() {
        Winehouse whouse = new Winehouse();
        ObservableList<Wine> fetchedWines = whouse.getWines();
        int initialNumWines = fetchedWines.size();

        //insert a wine not existing in house
        Wine newWine = new Wine();
        newWine.setName("Amarone della Valpolicella");
        newWine.setNotes("Dal colore rubino tendente al porpora, fitto ed impenetrabile");
        newWine.setVine("Blend");
        newWine.setYear(2001);
        int newWineQuantity = 2;
        newWine.setQty(newWineQuantity);
        whouse.addWine(newWine, newWineQuantity);
        fetchedWines = whouse.getWines();
        assertEquals(initialNumWines + 1, fetchedWines.size());
        assertTrue(fetchedWines.contains(newWine));
        assertEquals(newWineQuantity, whouse.getWineByNameAndYear(newWine.getName(), newWine.getYear()).get(0).getQty());

        //insert a wine already existing in house
        initialNumWines = fetchedWines.size();
        newWineQuantity = 5;
        whouse.addWine(newWine, newWineQuantity);
        assertEquals(initialNumWines, fetchedWines.size());
        assertEquals(newWine.getQty() + newWineQuantity, whouse.getWineByNameAndYear(newWine.getName(), newWine.getYear()).get(0).getQty());
    }

    @Test
    public void order15_removeWine() {
        Winehouse whouse = new Winehouse();

        Seller notAuthorizedSeller = new Seller("chris", "prova");
        Wine notExistingWine = new Wine("non esistente", "nessuna", "nessuna", 10, 0);
        //rimozione fatta con seller non autorizzato
        assertFalse(whouse.removeWine(notAuthorizedSeller, w1, 1));
        //rimozione fatta in quantità maggiore rispetto a quella disponibile
        assertFalse(whouse.removeWine(s1, w1, 5));
        //rimozione fatta su un vino non presente
        assertFalse(whouse.removeWine(s1, notExistingWine, 1));

        int initialQty = w1.getQty();
        assertTrue(whouse.removeWine(s1, w1, 2));
        //ripristino la modifica
        whouse.editWineQty(w1, initialQty);
    }

    @Test
    public void order16_requestWine() {
        Winehouse whouse = new Winehouse();
        ObservableList<Request> requestedWines = whouse.getRequestedWines();
        int requestedWinesInitialSize = requestedWines.size();
        whouse.requestWine(u1, "Not existing wine");
        requestedWines = whouse.getRequestedWines();
        assertEquals(requestedWinesInitialSize + 1, requestedWines.size());
    }

    @Test
    public void order17_getTopWines() {
        Winehouse whouse = new Winehouse();
        Pair<ObservableList<Wine>, HashMap<Wine, Integer>> pair = whouse.getTopWines();
        ObservableList<Wine> orderedWines = pair.getKey();
        HashMap<Wine, Integer> numOrders = pair.getValue();

        assertTrue(orderedWines.contains(w2));
        assertTrue(orderedWines.contains(w4));
        assertTrue(orderedWines.contains(w6));
        assertTrue(orderedWines.contains(w12));
        assertTrue(orderedWines.contains(w5));
        assertTrue(orderedWines.contains(w11));
        assertTrue(orderedWines.contains(w1));

        int expectedNumOrders;
        for (Wine w : numOrders.keySet())
        {
            switch (w.getName())
            {
                case "Lambrusco":
                    expectedNumOrders = 7;
                    break;
                case "Malvasia":
                    expectedNumOrders = 6;
                    break;
                case "Bonarda":
                    expectedNumOrders = 4;
                    break;
                case "Cabernet":
                    expectedNumOrders = 4;
                    break;
                case "Spumante":
                    expectedNumOrders = 2;
                    break;
                case "Merlot":
                    expectedNumOrders = 2;
                    break;
                case "Sangue di Giuda":
                    expectedNumOrders = 1;
                    break;
                default:
                    expectedNumOrders = -1;
                    break;
            }
            assertEquals(expectedNumOrders, (int)numOrders.get(w));
        }
    }

    @Test
    public void order18_deleteWine() {
        Winehouse whouse = new Winehouse();
        Wine notExistingWine = new Wine("Not existing", "not defined", "not defined", 0,0);
        int initialNumWines = whouse.getWines().size();

        // remove not existing wine
        whouse.deleteWine(notExistingWine);
        assertEquals(initialNumWines, whouse.getWines().size());

        // remove existing wine
        whouse.deleteWine(w8);
        assertEquals(initialNumWines - 1, whouse.getWines().size());

        //ripristino la modifica
        whouse.addWine(w8, w8.getQty());
    }

    @Test
    public void order19_orderWine() {
        Winehouse whouse = new Winehouse();
        int initialNumPendingOrders = whouse.getPendingOrdersNo();

        whouse.orderWine(u4, w8, 1);
        assertEquals(initialNumPendingOrders + 1, (int)whouse.getPendingOrdersNo());
    }

    @Test
    public void order20_shipWines() {
        Winehouse whouse = new Winehouse();

        assertTrue(whouse.getPendingOrdersNo() > 0);
        whouse.shipWines(s2);
        assertEquals(0, (int)whouse.getPendingOrdersNo());
    }

    @Test
    public void order21_getOrdersForUser() {
        Winehouse whouse = new Winehouse();

        assertEquals(2, whouse.getOrdersForUser(u1).size());
        assertEquals(2, whouse.getOrdersForUser(u3).size());
        assertEquals(1, whouse.getOrdersForUser(u6).size());
    }

    @Test
    public void order22_resetNewlyArrivedWines() {
        Winehouse whouse = new Winehouse();

        assertTrue(whouse.getMembers().contains(u6));
        assertEquals(1, u6.getNewlyArrivedWines());
        whouse.resetNewlyArrivedWines(u6);
        ObservableList<User> updatedMembersList = whouse.getMembers();
        for(User u : updatedMembersList)
        {
            if (u.getUsername().equals(u6.getUsername()))
                assertEquals(0, u.getNewlyArrivedWines());
        }
    }
}