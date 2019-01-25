/*14ianuarie - OOP
Class AnimalProd is a subclass of Product. It inherits from class Product the following variables: id, price,
weight, ValidityDate, stock.
It has two specific variables: name and storage temperature.

Main constructor is AnimalProd(id, price, weight, validityDate, stock, name, storageTemp).

Method @searchId(List<AnimalProds> animalProds, id) searches the Id (inserted by the user) in the animalProds list.
Method @displayStockAnimalProd(List<AnimalProd> animalProds): it prints the list of animal products which are preset
in the store (in the List -> animalProds)
Method @sellProduct(List<AnimalProd> animalProds, int aId, int stockSold): it diminishes the stock for the animal
product which has the ID inserted by the user. The user also inputs the number of stock which is sold. This method
also checks if the store has enough products to sell.



Disclaimer: some getters and setters are not used through out hte entire program.
I've created them in the flow of creation :P


@author Gheo Coanta
 */


package com.sci.tema14ian;

import java.util.List;

public class AnimalProd extends Product {
    private String nameOfAnimalProd;
    private double storageTemp;


    public AnimalProd(int aId, double aPrice, double aWeight, String aValidityDate, int aStock, String aName,
                      double aTemp) {
        super(aId, aPrice, aWeight, aValidityDate, aStock);
        this.nameOfAnimalProd = aName;
        this.storageTemp = aTemp;
    }

    public AnimalProd() {
    }

    public String getNameOfAnimalProd() {
        return nameOfAnimalProd;
    }

    public double getStorageTemp() {
        return storageTemp;
    }

    public void setAnimalId(int aId) {
        super.setId(aId);
    }


    public void setNameOfAnimalProd(String aName) {
        this.nameOfAnimalProd = aName;
    }

    public void setStorageTemp(double storageTemp) {
        this.storageTemp = storageTemp;
    }

    public boolean searchID(List<AnimalProd> animalProds, int aId) {
        boolean found = false;
        for (AnimalProd animalProd : animalProds)
            if (animalProd.getId() == aId) {
                found = true;
            }

        if (found) {
            return true;
        } else
            return false;
    }

    public void displayStockAnimalProd(List<AnimalProd> animalProds) {
        for (AnimalProd animalProd : animalProds) {
            System.out.println("Product " + animalProd.getNameOfAnimalProd() + " with id: "
                    + animalProd.getId() + " is in stock and you have a number of "
                    + animalProd.getStock() + " with the unit price of  " + animalProd.getPrice());
        }
    }

    public void sellProduct(List<AnimalProd> animalProds, int aId, int stockSold) {

        for (AnimalProd animalProd : animalProds) {
            if (animalProd.getId() == aId) {
                if (animalProd.getStock() - stockSold >= 0) {
                    animalProd.setStock(animalProd.getStock() - stockSold);
                    System.out.println("The new stock for product id " + animalProd.getId() + " is: " +
                            animalProd.getStock());
                } else {
                    System.out.println("You don't have that much stock. The stock for id: " + aId + "("
                            + animalProd.getNameOfAnimalProd() + ") is" + animalProd.getStock());
                }
            }
        }
    }
}


