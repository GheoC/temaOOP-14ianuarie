/*14ianuarie-OOP
Subclass Sale inherits from class Product the variables id and price.
It also has two variables: nameOfProduct and date.

Main constructor is Sale(id, price, date, stockSold, name);

Method displaySales(List<Sale> salesList, date) it prints out the sales on a specific day specified by the user

@author Gheo Coanta
 */

package com.sci.tema14ian;

import java.util.List;

public class Sale extends Product {
    private String date;
    private int stockSold;
    private String nameOfProduct;

    public Sale(){}

    public Sale(int aId, double aPrice, int stockSold, String aNameOfProd){
        super(aId,aPrice);
        this.stockSold=stockSold;
        this.nameOfProduct=aNameOfProd;
    }

    public Sale(int aId, double aPrice, String date, int stockSold, String aNameOfProd) {
        super(aId, aPrice);
        this.date = date;
        this.stockSold = stockSold;
        this.nameOfProduct = aNameOfProd;
    }

    public void displaySales(List<Sale> saleList){
        for(Sale sale : saleList){
            System.out.println("Product " + sale.nameOfProduct + " with id: "
                    + sale.getId() + " was sold in a quantity of "
                    + sale.stockSold + " with the unit price of  " + sale.getPrice() + ". Total value: "
                    + sale.stockSold * sale.getPrice()+" sold on  "+ sale.date);
        }
    }

    public double getPrice(){
        return super.getPrice();
    }

    public void displaySales(List<Sale> saleList, String aDate) {
        System.out.println("The sales for " + aDate + " are: ");
        for (Sale sale : saleList) {
            if (sale.date.equals(aDate)) {
                System.out.println("Product " + sale.nameOfProduct + " with id: "
                        + sale.getId() + " was sold in a quantity of "
                        + sale.stockSold + " with the unit price of  " + sale.getPrice() + ". Total value: "
                        + sale.stockSold * sale.getPrice());
            }
        }
    }
}
