/*14ianuarie-OOP
Class Vegetable is a subclass of Product. It inherits from class Product the following variables: id, price,
weight, ValidityDate, stock.
It has two specific variables: name and list of vitamins (vitamins).

Main constructor is Vegetable(id, price, weight, validityDate, stock, name, vitamins).

Method @searchId(List<Vegetable> vegetables, id) searches the Id (inserted by the user) in the vegetables list.
Method @displayStockVegetable(List<Vegetable> vegetables): it prints the list of vegetable products which are preset
in the store (in the List -> vegetables)
Method @sellProduct(List<Vegetable> vegetables, int aId, int stockSold): it diminishes the stock for the vegetable
product which has the ID inserted by the user. The user also inputs the number of stock which is sold. This method
also checks if the store has enough products to sell.



Disclaimer: some getters and setters are not used through out hte entire program.
I've created them in the flow of creation :P


@author Gheo Coanta
 */


package com.sci.tema14ian;

import java.util.List;

public class Vegetable extends Product {
    private String nameVegetable;
    private String vitamins;

    public Vegetable(){}

    public Vegetable(int aId, double aPrice, double aWeight, String aValidDate, int aStock, String aNameVegetable,
                     String aVitamins) {
        super(aId, aPrice, aWeight, aValidDate, aStock);
        this.nameVegetable = aNameVegetable;
        this.vitamins=aVitamins;
    }

    public String getNameVegetable() {
        return this.nameVegetable;
    }

    public String getVitamins() {
        return this.vitamins;
    }

    public boolean searchID(List<Vegetable> vegetables, int aId) {
        boolean found = false;
        for (Vegetable vegetable : vegetables)
            if (vegetable.getId() == aId) {
                found = true;
            }

        if (found) {
            return true;
        } else
            return false;
    }

    public void displayStockVegetable(List<Vegetable> vegetables) {
        for (Vegetable vegetable : vegetables) {
            System.out.println("Product " + vegetable.getNameVegetable() + " with id: "
                    + vegetable.getId() + " is in stock and you have a number of "
                    + vegetable.getStock() + " with the unit price of  " + vegetable.getPrice());
        }
    }

    public void sellProduct(List<Vegetable> vegetables, int aId, int stockSold) {

        for (Vegetable vegetable : vegetables) {
            if (vegetable.getId() == aId) {
                if (vegetable.getStock() - stockSold >= 0) {
                    vegetable.setStock(vegetable.getStock() - stockSold);
                    System.out.println("The new stock for product id " + vegetable.getId() + " is: " +
                            vegetable.getStock());
                } else {
                    System.out.println("You don't have that much stock. The stock for id: " + aId + "("
                            + vegetable.getNameVegetable() + ") is" + vegetable.getStock());
                }
            }
        }
    }
}
