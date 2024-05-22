package com.company;

import java.util.ArrayList;
import java.util.HashMap;


public class App {
    public static void main(String[] args) {

        Seller Martina = new Seller("Martina", "1574");
        User Giuseppe = new User("Giuseppe", "4792");
        User Derby = new User("Derby", "9627");
        User Samuele = new User("Samuele", "5532");
        Wine Lambrusco = new Wine("Lambrusco", "Suitable for meals", "Vineyard of Parma");
        Wine Sparkling_wine = new Wine("Sparkling wine", "Perfect for toasts", "Vineyard of Paris");
        Wine Rosè_wine = new Wine("Rosè wine", "Perfect combination with an aperitif", "Vineyard of Trentino Alto Adige");
        HashMap<Wine, InventoryItem> Wines = new HashMap<Wine, InventoryItem>();
        Wines.put(Lambrusco, new InventoryItem(1998, 4));
        Wines.put(Sparkling_wine, new InventoryItem(2005, 1));
        Wines.get(Lambrusco).modifyQuantity(2002, 4);
        Wines.put(Rosè_wine, new InventoryItem(2010, 2));
        ArrayList<Seller> Sellers = new ArrayList<Seller>();
        Sellers.add(Martina);
        ArrayList<User> Users = new ArrayList<User>();
        Users.add(Giuseppe);
        Users.add(Derby);
        Users.add(Samuele);
        Winehouse DeMaGiVineyard = new Winehouse("DeMaGi Vineyard", Wines, Sellers, Users);
        System.out.println(DeMaGiVineyard.getWinehouseData(Martina));

        //UX user signs up and buys some bottles of a UX wine
        DeMaGiVineyard.login(Giuseppe.getUsername(), Giuseppe.getPassword());
        Giuseppe.orderWineFromWinehouse(Lambrusco, DeMaGiVineyard, 1998, 2);
        Martina.shipWinesOrders(DeMaGiVineyard);

        //UY user registers and buys all bottles of a UY wine
        DeMaGiVineyard.login(Derby.getUsername(), Derby.getPassword());
        Derby.orderWineFromWinehouse(Sparkling_wine, DeMaGiVineyard, 2005, 1);
        Martina.shipWinesOrders(DeMaGiVineyard);

        //UZ user registers and wants to buy some bottles of a UY wine
        DeMaGiVineyard.login(Samuele.getUsername(), Samuele.getPassword());
        Samuele.orderWineFromWinehouse(Sparkling_wine, DeMaGiVineyard, 2005, 1);
        Samuele.requestWine(Sparkling_wine.getName(), DeMaGiVineyard);
        Martina.shipWinesOrders(DeMaGiVineyard);

        //An employee adds some bottles of UY wine
        Martina.addWines(Sparkling_wine, 2, 2005, DeMaGiVineyard);
        Martina.shipWinesOrders(DeMaGiVineyard);

        //Dashboard starts
        Login.loginPage(DeMaGiVineyard);
    }
}