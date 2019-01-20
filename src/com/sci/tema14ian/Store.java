/*TemaOOP-14ianuarie: Local Store Simulation.
Manages a store that has animal products and vegetables.
The basic functions are: adding new stock to a product, selling products from the store, displays sales on a specific
day specified by the user.
All products have on their packaging the price, validity date and weight.
The animal products in the store are the following: milk, eggs and various other products made out of milk (such
as cheese, yogurt, sour cream).
All animal products have on their packaging storage temperature.
All vegetable products describe on their packaging a list of vitamins they contain.


Each item refers to a product and has a stock number (could be 0 if it's out of stock).
A product is identified uniquely by an ID.

@author Gheo Coanta
 */

package com.sci.tema14ian;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Store {


    //*********************************************************************
    private static void displayMenu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("1. Create product and add it to stock");
        System.out.println("2. Sell product");
        System.out.println("3. Display daily sales report");
        System.out.println("4. Display stock"); //added an extra option for more transparency.
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    //*********************************************************************
    private static int inputId() {
        Scanner input = new Scanner(System.in);
        System.out.print("input the id:  ");
        return input.nextInt();
    }

    //*********************************************************************
    private static double inputPrice() {
        Scanner input = new Scanner(System.in);
        System.out.print("input the price: ");
        return input.nextDouble();
    }

    //*********************************************************************
    private static double inputWeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the weight: ");
        return input.nextDouble();
    }

    //*********************************************************************
    private static String inputValidityDate() {
        Scanner input = new Scanner(System.in);

        System.out.print("Input the Validity date. Please use this format 'yyyy-MM-dd' : ");
        return input.next();
    }

    //*********************************************************************
    private static String inputName() {
        Scanner input = new Scanner(System.in);

        System.out.print("Input the product name: ");
        return input.next();
    }

    //*********************************************************************
    private static double inputStorageTemp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the animal product storage temperature: ");
        return input.nextDouble();
    }

    //*********************************************************************
    private static String inputVitamins() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the vegetable list of vitamins: ");
        return input.next();
    }

    //*********************************************************************


    //*************************************** MAIN ********************************************
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char choiceMenuVar; //am ales variabila de tip char pentru a nu da eroare la apasare aiurea pe tastatura;
        List<AnimalProd> animalProds = new ArrayList<AnimalProd>();
        List<Vegetable> vegetables = new ArrayList<Vegetable>();
        List<Sales> salesList = new ArrayList<Sales>();


        do {
            displayMenu();
            choiceMenuVar = input.next().charAt(0);
            System.out.println("-------------------------------------------------------------");

            switch (choiceMenuVar) {
                case '1': {

                    //Adding a product to the store;

                    System.out.println("-------------------------------------------------------------");
                    System.out.print("Product type (1 - animal; 2 - vegetable):  ");
                    char productType = input.next().charAt(0);
                    switch (productType) {
                        case '1':
                            //Adding a animal product to the store;
                            // ID must be unique in both animal list and in vegetable list'
                            int idSearch = inputId();
                            Vegetable vegetable1 = new Vegetable();
                            if (vegetable1.searchID(vegetables, idSearch)) {
                                System.out.println("The ID you've selected is already present for a vegetable product!");

                            } else {


                                System.out.print("How much you want to restock: ");
                                int qStock = input.nextInt();
                                boolean prodFound = false;

                                if (animalProds.isEmpty()) {
                                    animalProds.add((new AnimalProd(idSearch, inputPrice(), inputWeight(),
                                            inputValidityDate(),
                                            qStock, inputName(), inputStorageTemp())));
                                } else {

                                    for (AnimalProd animalProd : animalProds) {

                                        if (animalProd.getId() == idSearch) {
                                            System.out.println("You had in stock " + animalProd.getStock());

                                            animalProd.addProd(qStock);

                                            prodFound = true;
                                        }


                                    }
                                    if (!prodFound) {
                                        animalProds.add((new AnimalProd(idSearch, inputPrice(), inputWeight(),
                                                inputValidityDate(), qStock, inputName(), inputStorageTemp())));
                                    }
                                }
                            }
                            break;


                        case '2':
                            //Adding a vegetable product to the store;
                            // ID must be unique in both animal list and in vegetable list'
                            idSearch = inputId();
                            AnimalProd animalProd = new AnimalProd();
                            if (animalProd.searchID(animalProds, idSearch)) {
                                System.out.println("The ID you've selected is already present or an animal product!");

                            } else {
                                System.out.print("How much you want to restock: ");
                                int qStock = input.nextInt();
                                boolean prodFound = false;

                                if (vegetables.isEmpty()) {
                                    vegetables.add((new Vegetable(idSearch, inputPrice(), inputWeight(),
                                            inputValidityDate(),
                                            qStock, inputName(), inputVitamins())));
                                } else {

                                    for (Vegetable vegetable : vegetables) {

                                        if (vegetable.getId() == idSearch) {
                                            System.out.println("You had in stock " + vegetable.getStock());

                                            vegetable.addProd(qStock);

                                            prodFound = true;
                                        }


                                    }
                                    if (!prodFound) {
                                        vegetables.add((new Vegetable(idSearch, inputPrice(), inputWeight(),
                                                inputValidityDate(),
                                                qStock, inputName(), inputVitamins())));
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("Not a valid option!!!");
                            break;

                    }
                }
                break;


                case '2':
                    //Selling a product

                    System.out.println("Your stock is: ");
                    AnimalProd animalProd = new AnimalProd();
                    Vegetable vegetable = new Vegetable();
                    animalProd.displayStockAnimalProd(animalProds);
                    vegetable.displayStockVegetable(vegetables);
                    System.out.println("-------------------------------------------------------------");

                    System.out.print("What product you want to sell ? Enter the ID of product ");
                    int aId = input.nextInt();
                    boolean found = false;

                    Date dNow = new Date();
                    SimpleDateFormat ft =
                            new SimpleDateFormat("yyyy.MM.dd");

                    //selling an animal product
                    if (animalProd.searchID(animalProds, aId)) {

                        System.out.print(("How much are you selling: "));
                        int stockSold = input.nextInt();
                        animalProd.sellProduct(animalProds, aId, stockSold);

                        for (AnimalProd animalProd1 : animalProds) {
                            if (animalProd1.getId() == aId) {

                                salesList.add(new Sales(aId, animalProd1.getPrice(), ft.format(dNow), stockSold,
                                        animalProd1.getNameOfAnimalProd()));
                            }
                        }
                        found = true; //if ID is present in animalProds list "found" = true
                    }

                    //selling a vegetable product
                    if (vegetable.searchID(vegetables, aId)) {

                        System.out.print(("How much are you selling: "));
                        int stockSold = input.nextInt();
                        vegetable.sellProduct(vegetables, aId, stockSold);

                        for (Vegetable vegetable1 : vegetables) {
                            if (vegetable1.getId() == aId) {

                                salesList.add(new Sales(aId, vegetable1.getPrice(), ft.format(dNow), stockSold,
                                        vegetable1.getNameVegetable()));
                            }
                        }

                        found = true; //if ID is present in vegetables list "found" = true
                    }
                    if (!found) {
                        System.out.println("The product with id: " + aId + " was not found in store");
                    }

                    break;

                case '3':
                    //Prints out a sales report. User provides the date of the report.

                    System.out.println("Sales report: ");
                    System.out.print("Please insert the date for which you want the sales report; Please use the " +
                            "following pattern: 'yyyy.MM.dd' : ");
                    String aDate = input.next();

                    Sales sales = new Sales();
                    sales.displaySales(salesList, aDate);
                    break;

                case '4':
                    // I've added a new function to the problem. I've founded visually easier to check the program out

                    System.out.println("Your stock is: ");
                    vegetable = new Vegetable();
                    vegetable.displayStockVegetable(vegetables);
                    animalProd = new AnimalProd();
                    animalProd.displayStockAnimalProd(animalProds);

                    break;
                case '5':
                    //Exit the menu
                    System.out.println("You have chose option 5. This will exit");
                    break;

                default:
                    System.out.println("You did not choose a valid option");
                    break;
            }

        }
        while (choiceMenuVar != '5');

    }

}
