package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Login contains helper methods to login a user and generate its dashboard.
 */
public class Login {

    /**
     * This method returns a dashboard given a user and a winehouse.
     *
     * @param username
     * @param password
     * @param shop
     * @return the dashboard.
     */
    private static Dashboard logIntoWinehouse(String username, String password, Winehouse shop) {
        Person loggingIn = shop.login(username, password);
        if (loggingIn == null) {
            return null;
        }
        if (loggingIn instanceof User)
            return new UserDashboard(new User(loggingIn), shop);
        else if (loggingIn instanceof Seller)
            return new AdminDashboard(new Seller(loggingIn), shop);
        else
            return null;
    }

    /**
     * This method generates the UI to log the user in.
     *
     * @param shop
     */
    public static void loginPage(Winehouse shop) {
        System.out.println("Please insert your username: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        System.out.println("Please insert your password: ");
        String username = input;
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown.");
            return;
        }
        String password = input;
        if (shop.isRegistered(username, password)) {
            Dashboard db = Login.logIntoWinehouse(username, password, shop);
            db.mainMenu();
        } else {
            System.out.println("Username or password entered are invalid.\n");
            loginPage(shop);
        }


    }
}
