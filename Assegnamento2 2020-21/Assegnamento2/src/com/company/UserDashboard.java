package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class with methods to display a user UI.
 */
public class UserDashboard extends Dashboard {

    /**
     * This constructor generates a dashboard from the user and the shop
     *
     * @param loggingIn
     * @param shop
     */
    public UserDashboard(User loggingIn, Winehouse shop) {
        super(loggingIn, shop);
    }

    /**
     * This method prints the main menu
     */
    public void mainMenu() {
        Integer action = 0;
        do {
            System.out.println("Welcome\n0) Exit\n1) Search a wine by his name\n2) Print all wines\n3) Request a wine");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown.");
                return;
            }
            switch (action) {
                case 1:
                    this.searchWineByTheName();
                    break;
                case 2:
                    this.printAllWines();
                    break;
                case 3:
                    this.requestWine();
                    break;

            }
        } while (!action.equals(0));
    }

    /**
     * This method searches a wine by its name
     */
    private void searchWineByTheName() {
        System.out.print("Insert the name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        HashMap<Wine, InventoryItem> foundWine = this.shop.findWinesByName(this.loggedIn, input);
        if (foundWine == null) {
            System.out.println("Wine not found.");
        } else {
            for (Map.Entry<Wine, InventoryItem> wineEntry : foundWine.entrySet()) {
                System.out.println(wineEntry.getKey().toString());
                System.out.println(wineEntry.getValue().toString());
                System.out.println("Wanna buy it? (Yes/No)");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown.");
                    return;
                }
                if (input.equals("Yes"))
                    this.orderWine(wineEntry.getKey());
            }
        }
    }

    /**
     * This method searches a requested wine
     */
    private void requestWine() {
        System.out.print("Insert name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        this.shop.requestWine(new User(this.loggedIn), input);
    }

    /**
     * This method orders a wine
     *
     * @param wine
     */
    private void orderWine(Wine wine) {
        System.out.print("Year: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        Integer year = Integer.valueOf(input);
        System.out.print("How many bottles: ");
        input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        Integer quantity = Integer.valueOf(input);
        new User(this.loggedIn).orderWineFromWinehouse(wine, this.shop, year, quantity);
    }

    /**
     * This method prints all the wines
     */
    public void printAllWines() {
        System.out.println(this.shop.AllWines());
    }
}