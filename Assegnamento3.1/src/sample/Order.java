package sample;

import javafx.beans.property.*;

/**
 * Order describes a wine order object.
 */


public class Order {

    private User orderer;
    private Wine orderedWine;
    private IntegerProperty quantity;
    private BooleanProperty shipped;


    /**
     * This constructor generates an empty order.
     */
    public Order() {
        this.orderer = new User();
        this.orderedWine = new Wine();
        this.quantity = new SimpleIntegerProperty(0);
        this.shipped = new SimpleBooleanProperty(false);
    }

    /**
     * This constructor generates an order from its data.
     *
     * @param orderer
     * @param orderedWine
     * @param quantity
     * @param shipped
     */
    public Order(final User orderer, final Wine orderedWine, final Integer quantity, final boolean shipped) {
        this.orderer = orderer;
        this.orderedWine = orderedWine;
        this.quantity = new SimpleIntegerProperty(quantity);
        this.shipped = new SimpleBooleanProperty(shipped);
    }


    /**
     * This method returns the user that ordered the wine.
     *
     * @return the user
     */
    public User getOrderer() {
        return this.orderer;
    }

    /**
     * This method sets the user that ordered the wine.
     *
     * @param orderer
     */
    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }

    /**
     * This method returns the ordered wine object.
     *
     * @return the wine
     */
    public Wine getOrderedWine() {
        return this.orderedWine;
    }

    /**
     * This method sets the ordered wine.
     *
     * @param orderedWine
     */
    public void setOrderedWine(Wine orderedWine) {
        this.orderedWine = orderedWine;
    }

    /**
     * This method gets the ordered quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return this.quantity;
    }

    /**
     * This method sets a quantity for the order.
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }


    /**
     * This method returns whether the order was shipped.
     *
     * @return whether the order is shipped
     */
    public boolean isShipped() {
        return this.shipped.get();
    }

    /**
     * This method sets whether the order was shipped or not
     *
     * @param shipped
     */
    public void setShipped(boolean shipped) {
        this.shipped.set(shipped);
    }

    public StringProperty getOrderStatus() {
        String status = this.shipped.getValue() ? "Shipped" : "Confirmed";
        return new SimpleStringProperty(status);
    }

    public BooleanProperty shippedProperty() {
        return this.shipped;
    }

    /**
     * This method generates a string describing the order
     */
    @Override
    public String toString() {
        return "Order: " + this.getOrderedWine() + " effettuato da " + this.getOrderer().getUsername() + " quantità:  " + this.getQuantity() + "\n";
    }
}

