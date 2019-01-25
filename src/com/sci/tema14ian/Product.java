/*14ianuarie-OOP
Product is the superclass which has the following variables: id, price, validityDate, weight, stock.
This class extends to the following classes: Vegetable, AnimalProd, Sale.

main constructor is Product(id, price, weight, validityDate, stock)
constructor Product(id,price) is used by the subclass Sale.

method addProd(newStock): adds up the stock inserted by the user to the existing stock.

Disclaimer: I think I should've created a method sellProd(stockSold) for selling products. Instead I've created
2 methods for this purpose in the subclasses Vegetable and AnimalProd.

@author Gheo Coanta
 */


package com.sci.tema14ian;

public class Product {
    private double price;
    private String validityDate;
    private int id;
    private double weight;
    private int stock;

    public Product(int aId, double aPrice, double aWeight, String aValidityDate, int aStock) {
        this.id = aId;
        this.price = aPrice;
        this.weight = aWeight;
        this.validityDate = aValidityDate;
        this.stock = aStock;
    }

    public Product(){}

    public Product(int aId, double aPrice){
        this.id=aId;
        this.price=aPrice;
    }

    public void addProd(int newStock) {
        this.stock = this.stock + newStock;
        System.out.println("You have now a number of: " + this.stock + " out of stock ID:  " + this.id);
    }

    public void setPrice(double aPrice) {
        this.price = aPrice;
    }

    public void setId(int aId) {
        this.id = aId;
    }

    public void setValidityDate(String aValidityDate) {
        this.validityDate = aValidityDate;
    }

    public void setWeight(double aWeight) {
        this.weight = aWeight;
    }

    public void setStock(int aStock) {
        this.stock = aStock;
    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getValidityDate() {
        return this.validityDate;
    }

    public int getStock() {
        return this.stock;
    }
}