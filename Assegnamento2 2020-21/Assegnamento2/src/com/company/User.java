package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * User is a simple user that can buy wine from the winehouse.
 */
public class User extends Person {

    /**
     * This constructor generates an empty user
     */
    public User() {
    }

    /**
     * This constructor generates a user from its username and password
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        super(username, password);
    }

    /**
     * This constructor generates a user from a generic person
     *
     * @param user
     */
    public User(Person user) {
        super(user.getUsername(), user.getPassword());
    }

    /**
     * This method notifies the user of a newly arrived wine. In real life, it could send an email.
     */
    public void notifyIfWineIsAdded() {
        System.out.println("A wine requested by " + this.getUsername() + " has been added.");
    }

    /**
     * This method orders a wine from the winehouse.
     *
     * @param wantedWine
     * @param shop
     * @param year
     * @param quantity
     */
    public void orderWineFromWinehouse(final Wine wantedWine, final Winehouse shop, final Integer year, final Integer quantity) {
        shop.orderWine(this, wantedWine, year, quantity);
    }

    /**
     * This method returns the user's orders
     *
     * @param shop
     * @return the orders
     */
    public ArrayList<Order> getMyOrders(final Winehouse shop) {
        return shop.getOrdersByUser(this);
    }

    /**
     * This method returns a wine from the winehouse
     *
     * @param name
     * @param shop
     * @return the wine and its quantities
     */
    public HashMap<Wine, InventoryItem> getWineByName(String name, Winehouse shop) {
        return shop.findWinesByName(this, name);
    }

    /**
     * This method returns wines by year.
     *
     * @param year
     * @param shop
     * @return the wines and their quantities
     */
    public HashMap<Wine, InventoryItem> getWinesByYear(Integer year, Winehouse shop) {
        return shop.findWinesByYear(this, year);
    }

    /*
     * This method adds a wine to the list of request
     *
     * @param requestedWine
     * @param shop
     */
    public void requestWine(String requestedWine, Winehouse shop) {
        shop.requestWine(this, requestedWine);
    }
}