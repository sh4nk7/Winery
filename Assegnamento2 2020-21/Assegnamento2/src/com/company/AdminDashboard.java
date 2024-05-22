package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Class with methods to display an admin UI.
 */
public class AdminDashboard extends Dashboard {

    /**
     * Constructor for the dashboard. Logs a user in.
     *
     * @param loggingIn the user
     * @param shop      the winehouse we're working on
     */
    public AdminDashboard(Seller loggingIn, Winehouse shop) {
        super(loggingIn, shop);
    }

    /**
     * Prints the main menu and calls the right functions
     */
    public void mainMenu() {
        Integer action = null;
        do {
            System.out.println("Welcome\n0) Exit\n1) Ship the orders\n2) Add some wine\n3) Check the requests\n4) Print all data\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown.");
                return;
            }
            switch (action) {
                case 1:
                    this.shipWine();
                    break;
                case 2:
                    this.addWine();
                    break;
                case 3:
                    this.printRequests();
                    break;
                case 4:
                    this.printWinehouse();
                    break;
            }
        } while (!action.equals(0));
    }

    /**
     * UI to ship the ordered wines.
     */
    private void shipWine() {
        new Seller(this.loggedIn).shipWinesOrders(this.shop);
        System.out.println("Finished shipping all the orders.");
    }

    /**
     * UI to add a new wine
     */
    private void addWine() {
        System.out.println("Is the wine already in our database? (Yes/No)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        if (input.equals("Yes")) {
            this.refillWarehouse();
        } else if (input.equals("No")) {
            this.addNewWine();
        } else {
            System.out.println("Your input is not valid.");
            return;
        }
    }

    /**
     * UI to add wine quantities.
     */
    private void refillWarehouse() {
        System.out.print("Insert the wine's name: ");
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
                System.out.println("Wanna refill it? (Yes/No)");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown.");
                    return;
                }
                if (input.equals("No"))
                    continue;


                System.out.println("What vintage do you want to refill? ");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown.");
                    return;
                }
                Integer year;
                try {
                    year = Integer.valueOf(input);
                } catch (NumberFormatException nfex) {
                    System.out.println("Wrong vintage inserted.");
                    return;
                }
                System.out.println("How many bottles? ");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown.");
                    return;
                }
                Integer quantity;
                try {
                    quantity = Integer.valueOf(input);
                } catch (NumberFormatException nfex) {
                    System.out.println("Wrong value inserted.");
                    return;
                }
                this.shop.addWine(new Seller(this.loggedIn), wineEntry.getKey(), year, quantity);
            }

        }
    }

    /**
     * UI to add a non-existent wine.
     */
    private void addNewWine() {
        System.out.print("Insert the wine name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        String name = input;

        System.out.println("Insert vineyard: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        String vine = input;

        System.out.println("Insert some notes: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        String notes = input;

        System.out.println("Insert the quantity of bottles: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        Integer quantity;
        try {
            quantity = Integer.valueOf(input);
        } catch (NumberFormatException nfex) {
            System.out.println("Wrong value inserted.");
            return;
        }
        System.out.println("Insert year: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        Integer year;
        try {
            year = Integer.valueOf(input);
        } catch (NumberFormatException nfex) {
            System.out.println("Wrong value inserted.");
            return;
        }
        this.shop.addWine(new Seller(this.loggedIn), new Wine(name, notes, vine), year, quantity);
    }

    /**
     * UI that prints all the requests made by users.
     */
    private void printRequests() {
        for (Request request : this.shop.getRequestedWines()) {
            System.out.println("Request:\n" + request.getWineName() + "\nMade by: " + request.getRequester().getUsername() + "\n");
        }
    }

    /**
     * UI that prints all the saved data.
     */
    private void printWinehouse() {
        System.out.println(this.shop.getWinehouseData(this.loggedIn));
    }
}
