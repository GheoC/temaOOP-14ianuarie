/*14ianuarie-OOP
Subclass Sales inherits from class Product the variables id and price.
It also has two variables: nameOfProduct and date.

Main constructor is Sales(id, price, date, stockSold, name);

Method displaySales(List<Sales> salesList, date) it prints out the sales on a specific day specified by the user

@author Gheo Coanta
 */

package com.sci.tema14ian;

import java.util.List;

public class Sales extends Product {
    private String date;
    private int stockSold;
    private String nameOfProduct;

    public Sales(){}

    public Sales(int aId, double aPrice, int stockSold, String aNameOfProd){
        super(aId,aPrice);
        this.stockSold=stockSold;
        this.nameOfProduct=aNameOfProd;
    }

    public Sales(int aId, double aPrice, String date, int stockSold, String aNameOfProd) {
        super(aId, aPrice);
        this.date = date;
        this.stockSold = stockSold;
        this.nameOfProduct = aNameOfProd;
    }

    public void displaySales(List<Sales> salesList){
        for(Sales sales: salesList){
            System.out.println("Product " + sales.nameOfProduct + " with id: "
                    + sales.getId() + " was sold in a quantity of "
                    + sales.stockSold + " with the unit price of  " + sales.getPrice() + ". Total value: "
                    + sales.stockSold * sales.getPrice()+" sold on  "+ sales.date);
        }
    }

    public double getPrice(){
        return super.getPrice();
    }

    public void displaySales(List<Sales> salesList, String aDate) {
        System.out.println("The sales for " + aDate + " are: ");
        for (Sales sales : salesList) {
            if (sales.date.equals(aDate)) {
                System.out.println("Product " + sales.nameOfProduct + " with id: "
                        + sales.getId() + " was sold in a quantity of "
                        + sales.stockSold + " with the unit price of  " + sales.getPrice() + ". Total value: "
                        + sales.stockSold * sales.getPrice());
            }
        }
    }
}
